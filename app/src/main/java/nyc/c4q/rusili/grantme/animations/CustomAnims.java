package nyc.c4q.rusili.grantme.animations;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;

import nyc.c4q.rusili.grantme.R;

// Provides custom animations.
// Parameters:  1) Parent View
//              2) Layout/container ID

public class CustomAnims {
    public CustomAnims () {
    }

    public boolean setSideToSideImageViewAnimation (View parentViewParam, int viewParam) {
        View imageViewLogo = (ImageView) parentViewParam.findViewById(viewParam);
        android.view.animation.Animation animLogoSidetoSide = AnimationUtils.loadAnimation(parentViewParam.getContext(), R.anim.anim_side_to_side);
        animLogoSidetoSide.setAnimationListener(new android.view.animation.Animation.AnimationListener() {
            public void onAnimationEnd (android.view.animation.Animation animation) {
            }

            public void onAnimationRepeat (android.view.animation.Animation animation) {
            }

            public void onAnimationStart (android.view.animation.Animation animation) {
            }
        });
        imageViewLogo.startAnimation(animLogoSidetoSide);
        return true;
    }

    public boolean setSideToSideEditTextAnimation (View parentViewParam, int viewParam) {
        View imageViewLogo = (EditText) parentViewParam.findViewById(viewParam);
        android.view.animation.Animation animLogoSidetoSide = AnimationUtils.loadAnimation(parentViewParam.getContext(), R.anim.anim_side_to_side);
        animLogoSidetoSide.setAnimationListener(new android.view.animation.Animation.AnimationListener() {
            public void onAnimationEnd (android.view.animation.Animation animation) {
            }

            public void onAnimationRepeat (android.view.animation.Animation animation) {
            }

            public void onAnimationStart (android.view.animation.Animation animation) {
            }
        });
        imageViewLogo.startAnimation(animLogoSidetoSide);
        return true;
    }

    public boolean setBounceImageViewAnimation (View parentViewParam, int viewParam) {
        View imageViewLogo = (ImageView) parentViewParam.findViewById(viewParam);
        android.view.animation.Animation animLogoSidetoSide = AnimationUtils.loadAnimation(parentViewParam.getContext(), R.anim.anim_bounce);
        animLogoSidetoSide.setAnimationListener(new android.view.animation.Animation.AnimationListener() {
            public void onAnimationEnd (android.view.animation.Animation animation) {
            }

            public void onAnimationRepeat (android.view.animation.Animation animation) {
            }

            public void onAnimationStart (android.view.animation.Animation animation) {
            }
        });
        imageViewLogo.startAnimation(animLogoSidetoSide);
        return true;
    }
}