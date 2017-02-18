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

/**
 * Created by Millochka on 2/18/17.
 */
public class LocationFragment extends Fragment {

    GridLayoutManager gridLayoutManager;
    LocationAdapter locationAdapter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View itemView = inflater.inflate(R.layout.location_layout, container, false);

        recyclerView = (RecyclerView) itemView.findViewById(R.id.location_rv);
        recyclerView.getItemAnimator().setChangeDuration(700);
        locationAdapter = new LocationAdapter();
        recyclerView.setAdapter(locationAdapter);
        gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        return itemView;

    }

    /*@Override
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
                    item.setIcon(AnimatedVectorDrawableCompat.create(MainActivity.this, R.drawable.avd_list_to_grid));
                    gridLayoutManager.setSpanCount(3);
                } else {
                    item.setIcon(AnimatedVectorDrawableCompat.create(MainActivity.this, R.drawable.avd_grid_to_list));
                    gridLayoutManager.setSpanCount(1);
                }
                ((Animatable) item.getIcon()).start();
                locationAdapter.notifyItemRangeChanged(0, locationAdapter.getItemCount());
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

}


