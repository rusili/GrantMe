package nyc.c4q.rusili.grantme.network.retrofit;

import java.util.List;

import nyc.c4q.rusili.grantme.network.pojo.JSONCourses;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Retrofit2Service {

    @GET ("")
    Call<List<JSONCourses>> getCourses();
}
