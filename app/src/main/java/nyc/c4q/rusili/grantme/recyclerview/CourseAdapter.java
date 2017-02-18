package nyc.c4q.rusili.grantme.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.network.pojo.JSONCourses;

public class CourseAdapter extends RecyclerView.Adapter {
    List<JSONCourses> listofCourses = new ArrayList<>();

    public CourseAdapter(){

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View mView = inflater.inflate(R.layout.course_item, parent, false);
        CourseViewholder viewHolder = new CourseViewholder(mView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder (RecyclerView.ViewHolder holder, int position) {
        CourseViewholder CourseViewholder = (CourseViewholder) holder;
        CourseViewholder.bind(listofCourses.get(position));
    }

    @Override
    public int getItemCount () {
        return listofCourses.size();
    }

    public void setListofCourses(List<JSONCourses> listofCourses) {
        this.listofCourses = listofCourses;
        this.notifyDataSetChanged();
    }


}
