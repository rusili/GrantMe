package nyc.c4q.rusili.grantme.fragments.mainscreen;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.network.pojo.JSONCourses;
import nyc.c4q.rusili.grantme.network.pojo.User;
import nyc.c4q.rusili.grantme.recyclerview.RecyclerViewProfileAdapter;

public class FragmentProfile extends Fragment{
    private View mView;
    private RecyclerView recyclerView;
    private TextView textViewUsername;
    private TextView textViewEmail;
    private ImageView imageViewPicture;

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
    private StorageReference storageRef = firebaseStorage.getReference();

    private List<JSONCourses> jsonCoursesList = new ArrayList<>();

    private String TAG = "Fragment Profile: ";

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
        RecyclerViewProfileAdapter recyclerViewProfileAdapter = new RecyclerViewProfileAdapter();

        recyclerView = (RecyclerView) mView.findViewById(R.id.fragment_profile_recyclerview_favorites);
        recyclerView.setLayoutManager(new LinearLayoutManager(mView.getContext()));
        recyclerView.setAdapter(recyclerViewProfileAdapter);
    }

    private void getFromDatabase(){
        String userUid = mAuth.getCurrentUser().getUid();
        DatabaseReference mDatabase = firebaseDatabase.getInstance().getReference("users");

        mDatabase.child(userUid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                textViewUsername.setText(user.getUsername());
                textViewEmail.setText(user.getEmail());
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}
