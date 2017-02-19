package nyc.c4q.rusili.grantme.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.fragments.mainscreen.FragmentProfile;
import nyc.c4q.rusili.grantme.utilities.FragmentBuilder;

public class ActivityTest extends AppCompatActivity {
    private FragmentBuilder fragmentBuilder;

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

        createProfileFragment();
    }

    private void createProfileFragment () {
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
