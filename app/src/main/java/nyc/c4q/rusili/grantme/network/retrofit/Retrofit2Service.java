package nyc.c4q.rusili.grantme.network.retrofit;

import java.util.List;

import nyc.c4q.rusili.grantme.network.pojo.JSONCourses;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Retrofit2Service {

    @GET ("resource/5teq-yyit.json")
    Call<List<JSONCourses>> getCourses();
}
