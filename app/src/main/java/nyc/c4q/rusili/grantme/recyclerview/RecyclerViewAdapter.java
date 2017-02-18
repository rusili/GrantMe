package nyc.c4q.rusili.grantme.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.network.pojo.JSONCourses;

public class RecyclerViewAdapter extends RecyclerView.Adapter {
    List<JSONCourses> listofCourses = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View mView = inflater.inflate(R.layout.recyclerview_viewholder, parent, false);
        RecyclerViewViewholder viewHolder = new RecyclerViewViewholder(mView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder (RecyclerView.ViewHolder holder, int position) {
        RecyclerViewViewholder RecyclerViewViewholder = (RecyclerViewViewholder) holder;
        RecyclerViewViewholder.bind(position);
    }

    @Override
    public int getItemCount () {
        return listofCourses.size();
    }
}
