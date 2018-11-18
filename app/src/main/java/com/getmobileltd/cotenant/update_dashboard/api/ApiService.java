package com.getmobileltd.cotenant.update_dashboard.api;

import com.getmobileltd.cotenant.registration.apppinmvp.CreateUserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {


    @POST("properties/filter")
    Call<TwoLocationResponse> getLocation(@Header("Authorization") String value, @Query("location_1") String location_1,
                                          @Query("location_2") String location_2);
}
