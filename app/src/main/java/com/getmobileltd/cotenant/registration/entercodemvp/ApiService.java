package com.getmobileltd.cotenant.registration.entercodemvp;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {


    @POST("verifications/user/verify")
    Call<EnterCodeResponse> createUser(@Body EnterCodeModel enterCodeModel);

}
