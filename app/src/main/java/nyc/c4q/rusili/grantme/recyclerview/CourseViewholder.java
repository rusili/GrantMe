package nyc.c4q.rusili.grantme.recyclerview;

import android.content.Intent;
import android.provider.CalendarContract;
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

import java.util.Calendar;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.network.pojo.JSONCourses;
import nyc.c4q.rusili.grantme.toasts.CustomToast;

public class CourseViewholder extends RecyclerView.ViewHolder {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    private CustomToast customToast;
    private final ImageButton expandBtn;
    private final ImageButton addToCalendar;
    private TextView mDescription;
    private TextView mCourseName;
    private TextView mWebSite;
    private TextView mBorough;
    private ImageButton imageButtonSaveFavorite;
    private TextView mPhoneNumber;
    private LinearLayout mLinearLayout;
    private TextView mAddress;
    private TextView mContactPerson;
    private TextView mNeighborhood;

    public CourseViewholder (View itemView) {
        super(itemView);
        mNeighborhood = (TextView) itemView.findViewById(R.id.neighborhood);
        mCourseName = (TextView) itemView.findViewById(R.id.course_name);
        mDescription = (TextView) itemView.findViewById(R.id.description);
        mWebSite = (TextView) itemView.findViewById(R.id.web_site);
        mBorough = (TextView) itemView.findViewById(R.id.borough);
        expandBtn = (ImageButton) itemView.findViewById(R.id.expand_btn);
        imageButtonSaveFavorite = (ImageButton) itemView.findViewById(R.id.savefavorite);
        mPhoneNumber = (TextView) itemView.findViewById(R.id.phone_number);
        addToCalendar = (ImageButton) itemView.findViewById(R.id.addtocalendar);
        mLinearLayout = (LinearLayout) itemView.findViewById(R.id.expanding_layout);
        mAddress = (TextView) itemView.findViewById(R.id.address);
        mContactPerson = (TextView) itemView.findViewById(R.id.contact_person);
    }

    public void bind (final JSONCourses course) {
        mCourseName.setText(course.getCourseName());
        mWebSite.setText(course.getWebsite());
        mNeighborhood.setText(course.getNeighborhood() + ", ");
        mBorough.setText(course.getBorough());
        String formattedNumber = PhoneNumberUtils.formatNumber(course.getPhone1());
        mPhoneNumber.setText("Phone Number: " + formattedNumber);
        mDescription.setText(course.getCoursedescription());

        mAddress.setText(course.getAddress1() + "," + course.getCity() + ",NY");
        mContactPerson.setText("Contact Person: " + course.getContactFirstname() + " " + course.getContactLastname());
        imageButtonSaveFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                saveToFavorites(course);
                imageButtonSaveFavorite.setColorFilter(ContextCompat.getColor(itemView.getContext(), R.color.colorAccent));
                customToast.show(itemView, "Saved as favorite");
            }
        });
        addToCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                saveToCalendar(view);

            }
        });

    }

    private void saveToFavorites (JSONCourses course) {
        DatabaseReference ref = mDatabase.child("users")
                .child(mAuth.getCurrentUser().getUid())
                .child("favorites");
        ref.push().setValue(course);
    }


    public ImageButton getExpandBtn () {
        return expandBtn;
    }

    public LinearLayout getmLinearLayout () {
        return mLinearLayout;
    }

    public TextView getmDescription () {
        return mDescription;
    }

    public TextView getmPhoneNumber () {
        return mPhoneNumber;
    }

    public void saveToCalendar (View view) {
        Calendar beginTime = Calendar.getInstance();
        beginTime.set(2017, 3, 19, 7, 30);
        Calendar endTime = Calendar.getInstance();
        endTime.set(2017, 3, 19, 8, 30);
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                .putExtra(CalendarContract.Events.TITLE, "Classes Start")
                .putExtra(CalendarContract.Events.DESCRIPTION, "Make sure grant application is completed")
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "Workforce")
                .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);
        view.getContext().startActivity(intent);
    }
}
