package nyc.c4q.rusili.grantme.fragments.mainscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.rusili.grantme.R;

public class FragmentEnding extends Fragment {
    private View mView;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_main_ending, container, false);

        return mView;
    }

    private void initializeViews () {
    }
}
