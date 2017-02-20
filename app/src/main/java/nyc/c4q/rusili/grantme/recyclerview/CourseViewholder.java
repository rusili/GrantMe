package nyc.c4q.rusili.grantme.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.network.pojo.JSONCourses;

public class CourseViewholder extends RecyclerView.ViewHolder{

    ImageButton expandBtn;
    TextView mDescription;
    private TextView mCourseName;
    private TextView mWebSite;
    private TextView mBorough;


    public CourseViewholder(View itemView) {
        super(itemView);
        mCourseName = (TextView) itemView.findViewById(R.id.course_name);
        mDescription = (TextView) itemView.findViewById(R.id.description);
        mWebSite = (TextView) itemView.findViewById(R.id.web_site);
        mBorough = (TextView) itemView.findViewById(R.id.borough);
        expandBtn = (ImageButton) itemView.findViewById(R.id.expand_btn);
    }

    public void bind (JSONCourses course) {

        mCourseName.setText(course.getCourseName());
        mWebSite.setText(course.getWebsite());
        mBorough.setText(course.getBorough());
        mDescription.setText(course.getCoursedescription());

    }
}
