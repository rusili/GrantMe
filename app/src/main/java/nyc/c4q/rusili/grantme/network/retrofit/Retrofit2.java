package nyc.c4q.rusili.grantme.network.retrofit;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.rusili.grantme.network.pojo.CourseFilter;
import nyc.c4q.rusili.grantme.network.pojo.JSONCourses;
import nyc.c4q.rusili.grantme.recyclerview.CourseAdapter;
import nyc.c4q.rusili.grantme.utilities.DataLists;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit2 {
    //https://data.cityofnewyork.us/resource/5teq-yyit.json

    private CourseAdapter mCourseAdapter;
    private int mViewId;
    private int mPosition;
    private DataLists dataLists;
    private String mFragId;

    public Retrofit2(CourseAdapter adapter, final String fragId, final int position) {
        this.mCourseAdapter = adapter;
        this.mFragId = fragId;
        this.mPosition = position;


    }

    public void connect() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final Retrofit2Service service = retrofit.create(Retrofit2Service.class);
        Call<List<JSONCourses>> getStuff = service.getCourses();
        getStuff.enqueue(new Callback<List<JSONCourses>>() {
            @Override
            public void onResponse(Call<List<JSONCourses>> call, Response<List<JSONCourses>> response) {
                if (response.isSuccessful()) {

                    List<JSONCourses> jsonCourses = response.body();

                    CourseFilter courseFilter = new CourseFilter(jsonCourses);

                    mCourseAdapter.setListofCourses(courseFilter.filterList(mPosition, mFragId));
                    Log.d("It's working", jsonCourses.get(2).getCourseName());

                }
            }

            @Override
            public void onFailure(Call<List<JSONCourses>> call, Throwable t) {
                Log.d("onFailure: ", t.toString());
                Log.d("It's not working", "It's not working");
            }
        });
    }


    public List<JSONCourses> borougthList(List<JSONCourses> inputList, int viewId) {

        String borough = "";
        List<JSONCourses> output = new ArrayList<>();


//        switch (viewId){
//            case R.id.brooklyn:
//                borough="Brooklyn";
//
//            break;
//            case R.id.queens:
//                borough="Queens";
//            break;
//            case R.id.bronx:
//                borough="Bronx";
//            break;
//        }


        for (JSONCourses item : inputList) {
            if (item.getBorough() != null) {
                if (item.getBorough().equalsIgnoreCase(borough)) {
                    output.add(item);
                }
            }
        }
        return output;
    }
}
