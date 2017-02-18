package nyc.c4q.rusili.grantme.network.retrofit;

import android.util.Log;

import java.util.List;

import nyc.c4q.rusili.grantme.network.pojo.JSONCourses;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit2 {

    public Retrofit2(){}

    public void connect(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Retrofit2Service service = retrofit.create(Retrofit2Service.class);
        Call<List<JSONCourses>> getStuff = service.getCourses();
        getStuff.enqueue(new Callback<List<JSONCourses>>() {
            @Override
            public void onResponse(Call<List<JSONCourses>> call, Response<List<JSONCourses>>response) {
                if (response.isSuccessful()) {
                }
            }

            @Override
            public void onFailure(Call<List<JSONCourses>> call, Throwable t) {
                Log.d("onFailure: ", t.toString());
            }
        });
    }
}
