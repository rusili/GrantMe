package nyc.c4q.rusili.grantme.activities;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;

import com.eftimoff.viewpagertransformers.TabletTransformer;

import de.hdodenhof.circleimageview.CircleImageView;
import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.alertdialog.CustomAlertDialog;
import nyc.c4q.rusili.grantme.fragments.mainscreen.FragmentProfile;
import nyc.c4q.rusili.grantme.network.pojo.Listener;
import nyc.c4q.rusili.grantme.recyclerview.NavDrawerAdapter;
import nyc.c4q.rusili.grantme.recyclerview.PagerAdapter;
import nyc.c4q.rusili.grantme.utilities.FragmentBuilder;

public class HomePage extends AppCompatActivity implements Listener {
    private FragmentBuilder fragmentBuilder;
    private TabLayout mTabLayout;
    private RecyclerView mDrawerRecyclerView;
    private ArrayAdapter<String> mAdapter;
    private DrawerLayout mDrawerLayout;
    public ProgressDialog progressDialog;

    @Override
    protected void onResume () {
        super.onResume();
        if (progressDialog!=null) {
            progressDialog.dismiss();
        }
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        progressDialog = new ProgressDialog(this);
        setUpRecyclerView();
        initializeViews();
    }

    private void initializeViews () {
        CircleImageView circleImageView = (CircleImageView) findViewById(R.id.profile_pic);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                createProfileFragment();
                mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                mDrawerLayout.closeDrawers();
            }
        });
    }

    private void setUpRecyclerView () {
        mDrawerRecyclerView = (RecyclerView) findViewById(R.id.navRecyclerView);
        mDrawerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        NavDrawerAdapter navDrawerAdapter = new NavDrawerAdapter(progressDialog);
        mDrawerRecyclerView.setAdapter(navDrawerAdapter);
    }





    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.addTab(mTabLayout.newTab().setText("Location"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Field"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Duration"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(2);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount(), this);

        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new TabletTransformer());
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


    }


    @Override
    public void showTrainings(final int position, final String fragId) {
        TrainingListFragment trainingListFragment = new TrainingListFragment();
        trainingListFragment.setmFragId(fragId);
        trainingListFragment.setmPosition(position);

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_left)
                .replace(R.id.content_container, trainingListFragment)
                .addToBackStack(null)
                .commit();
    }



    private void createProfileFragment () {
        FragmentProfile fragmentProfile = new FragmentProfile();
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_left)
                .replace(R.id.content_frame, fragmentProfile)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed () {
        Fragment currentFragment = getFragmentManager().findFragmentById(R.id.activity_start_layout_parent);
        if (currentFragment == null) {
            setExitDialog();
        } else {
            super.onBackPressed();
        }
    }

    private void setExitDialog () {
        CustomAlertDialog customAlertDialog = new CustomAlertDialog();
        customAlertDialog.setUp(this);
    }
}
