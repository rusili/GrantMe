package nyc.c4q.rusili.grantme.recyclerview;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.network.pojo.JSONCourses;
import nyc.c4q.rusili.grantme.toasts.CustomToast;

public class CourseViewholder extends RecyclerView.ViewHolder {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    private CustomToast customToast;
    private final ImageButton expandBtn;
    private TextView mDescription;
    private TextView mCourseName;
    private TextView mWebSite;
    private TextView mBorough;
    private ImageButton imageButtonSaveFavorite;
    private TextView mPhoneNumber;
    private LinearLayout mLinearLayout;
    private TextView mAddress;
    private TextView mContactPerson;

    public CourseViewholder(View itemView) {
        super(itemView);
        mCourseName = (TextView) itemView.findViewById(R.id.course_name);
        mDescription = (TextView) itemView.findViewById(R.id.description);
        mWebSite = (TextView) itemView.findViewById(R.id.web_site);
        mBorough = (TextView) itemView.findViewById(R.id.borough);
        expandBtn = (ImageButton) itemView.findViewById(R.id.expand_btn);
        imageButtonSaveFavorite = (ImageButton) itemView.findViewById(R.id.savefavorite);
        mPhoneNumber=(TextView) itemView.findViewById(R.id.phone_number);
        mLinearLayout= (LinearLayout) itemView.findViewById(R.id.expanding_layout);
        mAddress=(TextView) itemView.findViewById(R.id.address);
        mContactPerson=(TextView) itemView.findViewById(R.id.contact_person);
    }

    public void bind(final JSONCourses course) {
        mCourseName.setText(course.getCourseName());
        mWebSite.setText(course.getWebsite());
        mBorough.setText(course.getBorough());
        String formattedNumber = PhoneNumberUtils.formatNumber(course.getPhone1());
        mPhoneNumber.setText("Phone Number: " + formattedNumber);
        mDescription.setText(course.getCoursedescription());

        mAddress.setText(course.getAddress1()+","+course.getCity()+",NY");
        mContactPerson.setText("Contact Person: " + course.getContactFirstname() +" "+course.getContactLastname());
        imageButtonSaveFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToFavorites(course);
                imageButtonSaveFavorite.setColorFilter(ContextCompat.getColor(itemView.getContext(), R.color.colorAccent));
                customToast.show(itemView, "Saved as favorite");
            }
        });

    }

    private void saveToFavorites(JSONCourses course) {
        DatabaseReference ref = mDatabase.child("users")
                .child(mAuth.getCurrentUser().getUid())
                .child("favorites");
        ref.push().setValue(course);
    }



    public ImageButton getExpandBtn() {
        return expandBtn;
    }


    public LinearLayout getmLinearLayout() {
        return mLinearLayout;
    }

    public TextView getmDescription() {
        return mDescription;
    }

    public TextView getmPhoneNumber() {
        return mPhoneNumber;
    }
}
