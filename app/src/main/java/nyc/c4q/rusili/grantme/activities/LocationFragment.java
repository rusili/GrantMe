package nyc.c4q.rusili.grantme.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.network.pojo.Listener;

/**
 * Created by Millochka on 2/18/17.
 */
public class LocationFragment extends Fragment {

    GridLayoutManager gridLayoutManager;
    LocationAdapter locationAdapter;
    private RecyclerView recyclerView;
    private Listener mListener;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View itemView = inflater.inflate(R.layout.location_layout, container, false);

        recyclerView = (RecyclerView) itemView.findViewById(R.id.location_rv);
        recyclerView.getItemAnimator().setChangeDuration(700);
        locationAdapter = new LocationAdapter(mListener);
        recyclerView.setAdapter(locationAdapter);
        gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        return itemView;

    }

    public void setmListener(Listener listener) {
        this.mListener = listener;
    }
}


