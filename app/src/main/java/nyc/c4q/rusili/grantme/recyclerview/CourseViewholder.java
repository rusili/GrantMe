package nyc.c4q.rusili.grantme.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.network.pojo.JSONCourses;

public class CourseViewholder extends RecyclerView.ViewHolder{

    private TextView mCourseName;
    private TextView mWebSite;


    public CourseViewholder(View itemView) {
        super(itemView);
        mCourseName = (TextView) itemView.findViewById(R.id.course_name);
        mWebSite = (TextView) itemView.findViewById(R.id.web_site);
    }

    public void bind (JSONCourses course) {

        mCourseName.setText(course.getCourseName());
        mWebSite.setText(course.getWebsite());


    }
}
