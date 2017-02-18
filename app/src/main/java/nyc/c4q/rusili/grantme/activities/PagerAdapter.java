package nyc.c4q.rusili.grantme.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import nyc.c4q.rusili.grantme.network.pojo.Listener;

/**
 * Created by Millochka on 2/18/17.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {


    int mNumOfTabs;
    Listener mListener;

    public PagerAdapter(FragmentManager fm, int NumOfTabs, Listener listener) {
        super(fm);

        this.mNumOfTabs = NumOfTabs;
        this.mListener=listener;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                LocationFragment tab1 = new LocationFragment();
                tab1.setmListener(mListener);
                return tab1;
            case 1:
                FieldFragment tab2 = new FieldFragment();
                return tab2;
            case 2:
                DurationFragment tab3 = new DurationFragment();
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