package nyc.c4q.rusili.grantme.utilities;

import android.view.SoundEffectConstants;
import android.view.View;

public class SoundEffects {
    private View mView;

    public SoundEffects (View viewParam) {
        this.mView = viewParam;
    }

    public void set () {
        mView.playSoundEffect(SoundEffectConstants.CLICK);
    }
}
