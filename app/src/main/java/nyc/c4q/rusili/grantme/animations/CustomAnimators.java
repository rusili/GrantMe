package nyc.c4q.rusili.grantme.animations;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;

import nyc.c4q.rusili.grantme.R;

// Custom animations using animator sets
// Parameters:  1) Context
//              2) the view to be animated

public class CustomAnimators {

    public void setUp(Context contextParam, View viewParam){
        final AnimatorSet animator = (AnimatorSet) AnimatorInflater.loadAnimator(contextParam,
                R.animator.animator_card_flip_left_in);
        animator.setTarget(viewParam);
        animator.start();
    }
}
