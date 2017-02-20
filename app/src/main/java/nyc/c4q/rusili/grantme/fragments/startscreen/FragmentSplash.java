package nyc.c4q.rusili.grantme.fragments.startscreen;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import nyc.c4q.rusili.grantme.R;

public class FragmentSplash extends Fragment {
    private View mView;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragmentstart_splash, container, false);
        setLogoAnimation();
        return mView;
    }

    private void setLogoAnimation () {
        ImageView genieLogoFull = (ImageView) mView.findViewById(R.id.fragmentstart_splash_logo);
        genieLogoFull.setVisibility(View.VISIBLE);

        final AnimatorSet fadeInUp = (AnimatorSet) AnimatorInflater.loadAnimator(mView.getContext(),
                R.animator.animator_fade_in_up);

        fadeInUp.setTarget(genieLogoFull);
        fadeInUp.start();
    }
}