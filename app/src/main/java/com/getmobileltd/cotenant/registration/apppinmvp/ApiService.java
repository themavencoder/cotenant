package com.getmobileltd.cotenant.registration.apppinmvp;

import com.getmobileltd.cotenant.registration.aboutyoumvp.AboutYouResponse;
import com.getmobileltd.cotenant.registration.aboutyoumvp.Data;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @Headers("Content-Type: application/json")
    @POST("users/create")
    Call<CreateUserResponse> createUser(@Body Data data);

}
