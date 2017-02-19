package nyc.c4q.rusili.grantme.fragments.mainscreen;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.activities.LocationAdapter;
import nyc.c4q.rusili.grantme.network.pojo.Listener;

/**
 * Created by Millochka on 2/18/17.
 */
public class LocationFragment extends Fragment {

    private List<String> mCoursesList;
    GridLayoutManager gridLayoutManager;
    LocationAdapter locationAdapter;
    private RecyclerView recyclerView;
    private Listener mListener;
    private String mFragId;


    public void setmFragId(String mFragId) {
        this.mFragId = mFragId;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public LocationFragment() {
    }

    public void setmCoursesList(List<String> mCoursesList) {
        this.mCoursesList = mCoursesList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.setHasOptionsMenu(true);
        View itemView = inflater.inflate(R.layout.location_layout, container, false);

        recyclerView = (RecyclerView) itemView.findViewById(R.id.location_rv);
        recyclerView.getItemAnimator().setChangeDuration(700);
        locationAdapter = new LocationAdapter(mListener, mCoursesList, mFragId);
        recyclerView.setAdapter(locationAdapter);
        gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        return itemView;

    }


    public void setmListener(Listener listener) {
        this.mListener = listener;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_list_to_grid) {
            if (!((Animatable) item.getIcon()).isRunning()) {
                if (gridLayoutManager.getSpanCount() == 1) {
                    item.setIcon(AnimatedVectorDrawableCompat.create(getContext(), R.drawable.grid_to_list));
                    gridLayoutManager.setSpanCount(2);
                } else {
                    item.setIcon(AnimatedVectorDrawableCompat.create(getContext(), R.drawable.list_to_grid));
                    gridLayoutManager.setSpanCount(1);
                }
                ((Animatable) item.getIcon()).start();
                locationAdapter.notifyItemRangeChanged(0, locationAdapter.getItemCount());
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}


