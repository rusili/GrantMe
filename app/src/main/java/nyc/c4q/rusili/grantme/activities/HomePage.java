package nyc.c4q.rusili.grantme.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.network.pojo.Listener;
import nyc.c4q.rusili.grantme.recyclerview.PagerAdapter;

public class HomePage extends AppCompatActivity implements Listener {
    TabLayout mTabLayout;
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        mDrawerList = (ListView) findViewById(R.id.navList);
        addDrawerItems();


    }

    private void addDrawerItems() {
        String[] osArray = {"Profile", "Settings", "Saved Items", "Email", "Random"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(HomePage.this, "Time for an upgrade!", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.addTab(mTabLayout.newTab().setText("Locations"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Fields"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Durations"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(2);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount(),this);

        viewPager.setAdapter(adapter);
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
    public void showTrainings(final int position, String fragId) {
        TrainingListFragment trainingListFragment = new TrainingListFragment();
        trainingListFragment.setmFragId(fragId);
        trainingListFragment.setmPosition(position);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_container, trainingListFragment)
                .addToBackStack(null)
                .commit();
    }
}
