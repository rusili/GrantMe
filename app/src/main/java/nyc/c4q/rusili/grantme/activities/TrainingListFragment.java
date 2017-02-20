package nyc.c4q.rusili.grantme.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.network.pojo.JSONCourses;
import nyc.c4q.rusili.grantme.network.retrofit.Retrofit2;
import nyc.c4q.rusili.grantme.recyclerview.CourseAdapter;

/**
 * Created by Millochka on 2/18/17.
 */
public class TrainingListFragment extends Fragment {

    private String mFragId;
    private int mPosition;
    private RecyclerView mRecyclerView;
    private Retrofit2 mRetrofit;
    List<JSONCourses> mListofCourses = new ArrayList<>();
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private SearchView mSearch;
    private  CourseAdapter mCourseAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View itemView = inflater.inflate(R.layout.courses_list, container, false);

        return itemView;

    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
         mCourseAdapter = new CourseAdapter();
        mCourseAdapter.setRV(mRecyclerView);
        mRetrofit = new Retrofit2(mCourseAdapter, mFragId, mPosition);
        mRetrofit.connect();
        mRecyclerView.setAdapter(mCourseAdapter);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        mSearch=(SearchView) view.findViewById(R.id.search_course);
        mSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            List<JSONCourses> temp = new ArrayList<JSONCourses>();
            @Override
            public boolean onQueryTextSubmit(String query) {
                temp =mCourseAdapter.getmListofCourses();
                filter(query, temp);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                temp =mCourseAdapter.getmListofCourses();
                filter(newText, temp);
                return true;
            }
        });
        mSearch.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                refreshItems();

                return true;
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                refreshItems();
            }
        });


    }

    public void filter(String text, List<JSONCourses> list){
         final List<JSONCourses> temp = new ArrayList<>();
        for(JSONCourses d: list) {

            switch (mFragId){

                case"Location":
                    if (d.getKeywords() != null) {
                        if (d.getKeywords().toLowerCase().contains(text.toLowerCase())) {
                            temp.add(d);
                        }
                    }

                break;
                case"Field":

                    if (d.getBorough() != null) {
                        if (d.getBorough().toLowerCase().contains(text.toLowerCase())) {
                            temp.add(d);
                        }
                    }

                break;

            }


        }

        mCourseAdapter.setListofCourses(temp);
        mCourseAdapter.notifyDataSetChanged();
    }

    public void refreshItems() {
        mRetrofit.connect();
        mCourseAdapter.notifyDataSetChanged();
        onItemsLoadComplete();

    }

    public void onItemsLoadComplete() {

        mSwipeRefreshLayout.setRefreshing(false);
    }

    public void setmFragId(String fragId) {
        this.mFragId = fragId;
    }

    public void setmPosition(final int mPosition) {
        this.mPosition = mPosition;
    }


}
