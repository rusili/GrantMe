package nyc.c4q.rusili.grantme.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.rusili.grantme.R;

/**
 * Created by Millochka on 2/18/17.
 */
public class LocationFragment extends Fragment{

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View itemView = inflater.inflate(R.layout.location_layout, container, false);

        return itemView;

    }


}
