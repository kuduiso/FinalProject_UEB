package id.kuduiso.fplistfootball.data.remote;

import id.kuduiso.fplistfootball.model.ResponseTeams;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("search_all_teams.php")
    Call<ResponseTeams> getAllTeam(
            @Query("s") String s,
            @Query("c") String c
            );
}
