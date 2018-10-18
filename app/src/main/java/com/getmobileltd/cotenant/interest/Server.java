package com.getmobileltd.cotenant.interest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Server {

    @GET ("movie/popular")
    Call<InterestResponse> getPopularMovies(@Query("api_key") String apiKey);

}
