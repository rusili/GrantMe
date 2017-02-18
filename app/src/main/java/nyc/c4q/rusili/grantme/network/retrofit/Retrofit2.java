package nyc.c4q.rusili.grantme.network.retrofit;

import android.util.Log;

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
        Call<JSONCourses> getStuff = service.getCourses();
        getStuff.enqueue(new Callback<JSONCourses>() {
            @Override
            public void onResponse(Call<JSONCourses> call, Response<JSONCourses> response) {
                if (response.isSuccessful()) {
                }
            }

            @Override
            public void onFailure(Call<JSONCourses> call, Throwable t) {
                Log.d("onFailure: ", t.toString());
            }
        });
    }
}
