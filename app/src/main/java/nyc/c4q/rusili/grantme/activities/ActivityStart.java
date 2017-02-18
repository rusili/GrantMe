package nyc.c4q.rusili.grantme.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.alertdialog.CustomAlertDialog;
import nyc.c4q.rusili.grantme.fragments.startscreen.FragmentCreateAccount;
import nyc.c4q.rusili.grantme.fragments.startscreen.FragmentLogin;
import nyc.c4q.rusili.grantme.fragments.startscreen.FragmentSplash;
import nyc.c4q.rusili.grantme.utilities.FragmentBuilder;
import nyc.c4q.rusili.grantme.utilities.SoundEffects;

public class ActivityStart extends AppCompatActivity{
    private FragmentBuilder fragmentBuilder;
    private SoundEffects soundEffects;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        soundEffects = new SoundEffects(getWindow().getDecorView().getRootView());

        createSplashFragment();
    }

    private void createSplashFragment(){
        FragmentSplash fragmentSplash = new FragmentSplash();
        fragmentBuilder = new FragmentBuilder.Builder()
                .activity(this)
                .fragment(fragmentSplash)
                .containerID(R.id.activity_start_layout_parent)
                .animations(R.animator.animator_null, R.animator.animator_null)
                .backstack(false)
                .build();
        fragmentBuilder.inflateFragment();
    }

    private void createLoginFragment(){
        FragmentLogin fragmentLogin = new FragmentLogin();
        fragmentBuilder = new FragmentBuilder.Builder()
                .activity(this)
                .fragment(fragmentLogin)
                .containerID(R.id.activity_start_layout_parent)
                .backstack(false)
                .build();
        fragmentBuilder.inflateFragment();
    }

    private void createCreateAccountFragment () {
        FragmentCreateAccount fragStartCreateAccount = new FragmentCreateAccount();
        fragmentBuilder = new FragmentBuilder.Builder()
                .activity(this)
                .fragment(fragStartCreateAccount)
                .animations(R.animator.animator_slide_in_right, R.animator.animator_slide_out_right)
                .containerID(R.id.activity_start_layout_parent)
                .backstack(true)
                .build();
        fragmentBuilder.inflateFragment();
    }

    public void onClickSplashtoLogin (View view) {
        soundEffects.set();
        createLoginFragment();
    }

    public void onClickCreateNewAccountScreen (View view) {
        createCreateAccountFragment();
    }

    @Override
    public void onBackPressed () {
        Fragment currentFragment = getFragmentManager().findFragmentById(R.id.activity_start_layout_parent);
        if (currentFragment instanceof FragmentLogin) {
            setExitDialog();
        } else if (currentFragment instanceof FragmentCreateAccount) {
            super.onBackPressed();
            createLoginFragment();
        } else {
            setExitDialog();
        }
    }

    private void setExitDialog(){
        CustomAlertDialog customAlertDialog = new CustomAlertDialog();
        customAlertDialog.setUp(this);
    }
}
