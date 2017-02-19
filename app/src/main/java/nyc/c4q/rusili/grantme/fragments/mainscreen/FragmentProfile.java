package nyc.c4q.rusili.grantme.fragments.mainscreen;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.network.pojo.JSONCourses;
import nyc.c4q.rusili.grantme.network.pojo.User;
import nyc.c4q.rusili.grantme.recyclerview.CourseAdapter;

import static android.app.Activity.RESULT_OK;

public class FragmentProfile extends Fragment {
    private View mView;
    private RecyclerView recyclerView;
    private TextView textViewUsername;
    private TextView textViewEmail;
    private ImageView imageViewPicture;

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
    private StorageReference storageRef = firebaseStorage.getReference();

    private List <JSONCourses> jsonCoursesList = new ArrayList <>();

    private String TAG = "Fragment Profile: ";
    private String userUid;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_main_profile, container, false);
        initializeViews();
        getFromDatabase();
        return mView;
    }

    private void initializeViews () {
        textViewUsername = (TextView) mView.findViewById(R.id.fragment_profile_name);
        textViewEmail = (TextView) mView.findViewById(R.id.fragment_profile_email);
        imageViewPicture = (ImageView) mView.findViewById(R.id.fragment_profile_picture);
        imageViewPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                setProfilePic();
            }
        });

        recyclerView = (RecyclerView) mView.findViewById(R.id.fragment_profile_recyclerview_favorites);
        recyclerView.setLayoutManager(new LinearLayoutManager(mView.getContext()));
    }

    private void getFromDatabase () {
        userUid = mAuth.getCurrentUser().getUid();
        DatabaseReference mDatabase = firebaseDatabase.getInstance().getReference("users");
        getProfilePic(userUid);

        mDatabase.child(userUid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                textViewUsername.setText(user.getUsername());
                textViewEmail.setText(user.getEmail());

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    JSONCourses jsonCourses = snapshot.getValue(JSONCourses.class);
                    jsonCoursesList.add(jsonCourses);
                }
                CourseAdapter profileFavoritesAdapter = new CourseAdapter();
                profileFavoritesAdapter.setListofCourses(jsonCoursesList);
                recyclerView.setAdapter(profileFavoritesAdapter);
            }

            @Override
            public void onCancelled (DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    private void getProfilePic (String userUid) {
        // gs://grantme-81306.appspot.com/profile_images/swiprlogotop.png

        StorageReference imagesRef = storageRef.child("profile_images");
        String filename = userUid + ".jpg";
        //String filename = "swiprlogotop.png";
        StorageReference getRef = imagesRef.child(filename);

        getRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener <Uri>() {
            @Override
            public void onSuccess (Uri uri) {
                Picasso.with(mView.getContext()).load(uri.toString()).into(imageViewPicture);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure (@NonNull Exception exception) {
            }
        });
    }

    private void setProfilePic () {
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(galleryIntent, "Select Picture"), 1);
    }

    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data) {
        android.net.Uri uri = null;
        // Loads gallery picture into showPicture
        File photo = null;
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            uri = data.getData();
            photo = new File(String.valueOf(uri));
            Picasso.with(mView.getContext())
                    .load(uri)
                    .fit()
                    .into(imageViewPicture);
        }
        uploadProfilePic(uri);
    }

    private void uploadProfilePic (Uri uri) {
        StorageReference storageRef = firebaseStorage.getReferenceFromUrl("gs://grantme-81306.appspot.com");
        StorageReference pictureImagesRef = storageRef.child("profile_images/" + userUid + ".jpg");
        UploadTask uploadTask = pictureImagesRef.putFile(uri);

        // Register observers to listen for when the download is done or if it fails
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure (@NonNull Exception exception) {
            }
        }).addOnSuccessListener(new OnSuccessListener <UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess (UploadTask.TaskSnapshot taskSnapshot) {
                Uri downloadUrl = taskSnapshot.getDownloadUrl();
            }
        });
    }
}
