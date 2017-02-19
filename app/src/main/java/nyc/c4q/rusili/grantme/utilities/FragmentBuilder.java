package nyc.c4q.rusili.grantme.utilities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

import nyc.c4q.rusili.grantme.R;

// A fragment builder with in/out animations & backstack optional
// Parameters:  1) Parent Activity
//              2) Instance of Fragment
//              3) Layout/Container ID
// Optional:    1) In/Out Animations
//              2) Backstack = false

public class FragmentBuilder {
    private Activity activityParam;
    private Fragment fragmentParam;
    private int containerIDParam;
    private int inAnimationParam;
    private int outAnimationParam;
    private boolean backstackParam;
    private FragmentTransaction fragmentTransaction;

    private FragmentBuilder (Builder builder) {
        this.activityParam = builder.activityParam;
        this.fragmentParam = builder.fragmentParam;
        this.containerIDParam = builder.containerIDParam;
        this.inAnimationParam = builder.inAnimationParam;
        this.outAnimationParam = builder.outAnimationParam;
        this.backstackParam = builder.backstackParam;
    }

    public static class Builder {
        private Activity activityParam;
        private Fragment fragmentParam;
        private int containerIDParam;
        private int inAnimationParam = R.animator.animator_slide_in_left;
        private int outAnimationParam = R.animator.animator_slide_in_right;
        private boolean backstackParam = true;

        public Builder activity (Activity activityP) {
            this.activityParam = activityP;
            return this;
        }

        public Builder fragment (Fragment fragmentP) {
            this.fragmentParam = fragmentP;
            return this;
        }

        public Builder containerID (int intP) {
            this.containerIDParam = intP;
            return this;
        }

        public Builder animations (int inAnimationP, int outAnimationP) {
            this.inAnimationParam = inAnimationP;
            this.outAnimationParam = outAnimationP;
            return this;
        }

        public Builder backstack (boolean booleanP) {
            this.backstackParam = booleanP;
            return this;
        }

        public FragmentBuilder build () {
            return new FragmentBuilder(this);
        }
    }

    public void inflateFragment () {
        if (!backstackParam) {
            fragmentTransaction = activityParam.getFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(inAnimationParam, outAnimationParam)
                    .replace(containerIDParam, fragmentParam)
                    .commit();
        } else {
            fragmentTransaction = activityParam.getFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(inAnimationParam, outAnimationParam, R.animator.animator_slide_in_right, R.animator.animator_slide_out_right)
                    .replace(containerIDParam, fragmentParam)
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void destroyFragment(Fragment fragmentParam){
        fragmentTransaction = activityParam.getFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragmentParam).commit();
    }
}