package nyc.c4q.rusili.grantme.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View itemView = inflater.inflate(R.layout.courses_list, container, false);

        return itemView;

    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CourseAdapter courseAdapter = new CourseAdapter();
        mRetrofit = new Retrofit2(courseAdapter, mFragId, mPosition);
        mRetrofit.connect();
        mRecyclerView.setAdapter(courseAdapter);


    }

    public void setmFragId(String fragId) {
        this.mFragId = fragId;
    }

    public void setmPosition(final int mPosition) {
        this.mPosition = mPosition;
    }


}
