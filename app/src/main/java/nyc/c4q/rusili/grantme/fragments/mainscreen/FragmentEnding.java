package nyc.c4q.rusili.grantme.fragments.mainscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.shimmer.ShimmerFrameLayout;

import nyc.c4q.rusili.grantme.R;

public class FragmentEnding extends Fragment {
    private View mView;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_main_ending, container, false);
        initializeViews();
        return mView;
    }

    private void initializeViews () {
        ShimmerFrameLayout container =
                (ShimmerFrameLayout) mView.findViewById(R.id.fragment_ending_image_logo_shimmer);
        container.setBaseAlpha(0.8f);
        container.setDuration(1500);
        container.setRepeatDelay(3000);
        container.startShimmerAnimation();
    }
}
