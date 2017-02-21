package nyc.c4q.rusili.grantme.recyclerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import nyc.c4q.rusili.grantme.fragments.mainscreen.LocationFragment;
import nyc.c4q.rusili.grantme.network.pojo.Listener;
import nyc.c4q.rusili.grantme.utilities.DataSets;


public class PagerAdapter extends FragmentStatePagerAdapter {
    DataSets dataLists = new DataSets();
    private final List<String> boroughs;
    private final List<String> fields;
    private final List<String> duration;
    int mNumOfTabs;
    Listener mListener;

    public PagerAdapter(FragmentManager fm, int NumOfTabs, Listener listener) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.mListener = listener;
        dataLists.initMainLists();
        this.boroughs = dataLists.getLocationList();
        this.fields = dataLists.getFieldList();
        this.duration = dataLists.getDurationList();
    }


    @Override
    public Fragment getItem(int position) {


        switch (position) {
            case 0:
                LocationFragment tab1 = new LocationFragment();
                tab1.setmListener(mListener);
                tab1.setmCoursesList(boroughs);
                tab1.setmFragId("Location");
                return tab1;
            case 1:
                LocationFragment tab2 = new LocationFragment();
                tab2.setmListener(mListener);
                tab2.setmCoursesList(fields);
                tab2.setmFragId("Field");
                return tab2;
            case 2:
                LocationFragment tab3 = new LocationFragment();
                tab3.setmListener(mListener);
                tab3.setmCoursesList(duration);
                tab3.setmFragId("Duration");
                return tab3;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}