package nyc.c4q.rusili.grantme.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.network.pojo.JSONCourses;

public class CourseViewholder extends RecyclerView.ViewHolder {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();


    private final ImageButton expandBtn;
    private TextView mDescription;
    private TextView mCourseName;
    private TextView mWebSite;
    private TextView mBorough;
    private ImageButton imageButtonSaveFavorite;

    public CourseViewholder (View itemView) {
        super(itemView);
        mCourseName = (TextView) itemView.findViewById(R.id.course_name);
        mDescription = (TextView) itemView.findViewById(R.id.description);
        mWebSite = (TextView) itemView.findViewById(R.id.web_site);
        mBorough = (TextView) itemView.findViewById(R.id.borough);
        expandBtn = (ImageButton) itemView.findViewById(R.id.expand_btn);
        imageButtonSaveFavorite = (ImageButton) itemView.findViewById(R.id.savefavorite);

    }

    public void bind (final JSONCourses course) {
        mCourseName.setText(course.getCourseName());
        mWebSite.setText(course.getWebsite());
        mBorough.setText(course.getBorough());
        mDescription.setText(course.getCoursedescription());
        imageButtonSaveFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                saveToFavorites(course);
            }
        });
        expandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDescription.getVisibility() == View.GONE) {
                    mDescription.setVisibility(View.VISIBLE);
                    expandBtn.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    mDescription.setVisibility(View.GONE);
                    expandBtn.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });

    }

    private void saveToFavorites (JSONCourses course ) {
        DatabaseReference ref = mDatabase.child("users")
                .child(mAuth.getCurrentUser().getUid())
                .child("favorites");
        ref.push().setValue(course);
    }
}