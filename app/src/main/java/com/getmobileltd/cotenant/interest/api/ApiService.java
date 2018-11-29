package com.getmobileltd.cotenant.interest.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("interests/cotenant/{cotenant_id}")
    Call<InterestResponse> getLocation(@Header("Authorization") String value, @Path("cotenant_id") int cotenant_id);


}
