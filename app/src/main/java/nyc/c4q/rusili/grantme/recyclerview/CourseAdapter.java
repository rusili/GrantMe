package nyc.c4q.rusili.grantme.recyclerview;

import android.support.annotation.Nullable;
import android.support.transition.TransitionManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.network.pojo.JSONCourses;

public class CourseAdapter extends RecyclerView.Adapter {
    List<JSONCourses> mListofCourses = new ArrayList<>();
    private int mExpandedPostion = -1;
    private RecyclerView mRecyclerView;
    private boolean showFavorites;


    public CourseAdapter (boolean b){
        showFavorites = b;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View mView = inflater.inflate(R.layout.course_item, parent, false);
        CourseViewholder viewHolder = new CourseViewholder(mView);
        if (!showFavorites){
            mView.findViewById(R.id.savefavorite).setVisibility(View.GONE);
        }
        return viewHolder;
    }

    @Override
    @Nullable
    public void onBindViewHolder (RecyclerView.ViewHolder holder, final int position) {
        CourseViewholder courseViewholder = (CourseViewholder) holder;
        JSONCourses item = mListofCourses.get(position);
        courseViewholder.bind(item);

        final boolean isExpanded = position == mExpandedPostion;
        courseViewholder.getmLinearLayout().setVisibility(isExpanded?View.VISIBLE:View.GONE);
        courseViewholder.itemView.setActivated(isExpanded);
        courseViewholder.getExpandBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mExpandedPostion = isExpanded ? -1:position;
                TransitionManager.beginDelayedTransition(mRecyclerView);
                notifyDataSetChanged();
            }
        });


    }

    @Override
    @Nullable
    public int getItemCount () {
        return mListofCourses.size();
    }

    public void setListofCourses(List<JSONCourses> listofCourses) {
        this.mListofCourses = listofCourses;
        this.notifyDataSetChanged();
    }


    public void setRV(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;

    }

    public List<JSONCourses> getmListofCourses() {
        return mListofCourses;
    }

}
