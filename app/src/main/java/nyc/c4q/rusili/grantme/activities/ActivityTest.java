package nyc.c4q.rusili.grantme.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.fragments.mainscreen.FragmentProfile;
import nyc.c4q.rusili.grantme.utilities.FragmentBuilder;

public class ActivityTest extends AppCompatActivity{
    private FragmentBuilder fragmentBuilder;

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

        createProfileFragment();
    }

    private void createProfileFragment(){
        FragmentProfile fragmentProfile = new FragmentProfile();
        fragmentBuilder = new FragmentBuilder.Builder()
                .activity(this)
                .containerID(R.id.activity_start_layout_parent2)
                .fragment(fragmentProfile)
                .backstack(false)
                .build();
        fragmentBuilder.inflateFragment();
    }
}
