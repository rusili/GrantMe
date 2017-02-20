package nyc.c4q.rusili.grantme.activities;

import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.Fragment;

import nyc.c4q.rusili.grantme.R;

/**
 * Created by mathcore on 2/18/17.
 */

public class GrantInfoFragment extends Fragment {


    public void grantInfo() {
        String url = "http://mtprawvwsbswtp.nyc.gov/popups/ITG.aspx";
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        builder.setToolbarColor(getResources().getColor(R.color.colorPrimaryDark));
        customTabsIntent.launchUrl(getActivity(), Uri.parse(url));

    }
}
