package nyc.c4q.rusili.grantme.network.retrofit;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.rusili.grantme.network.pojo.JSONCourses;
import nyc.c4q.rusili.grantme.recyclerview.CourseAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit2 {

    CourseAdapter mCourseAdapter;
    List<JSONCourses> mJSONCourses = new ArrayList<>();

    public Retrofit2(CourseAdapter adapter){
        mCourseAdapter = adapter;

    }

    public void connect(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final Retrofit2Service service = retrofit.create(Retrofit2Service.class);
        Call<List<JSONCourses>> getStuff = service.getCourses();
        getStuff.enqueue(new Callback<List<JSONCourses>>() {
            @Override
            public void onResponse(Call<List<JSONCourses>> call, Response<List<JSONCourses>>response) {
                if (response.isSuccessful()) {

                    List<JSONCourses> jsonCourses= response.body();

                    setmJSONCourses(jsonCourses);
                    mCourseAdapter.setListofCourses(jsonCourses);
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

    public List<JSONCourses> getmJSONCourses() {
        return mJSONCourses;
    }

    public void setmJSONCourses(List<JSONCourses> mJSONCourses) {
        this.mJSONCourses = mJSONCourses;
    }
}
