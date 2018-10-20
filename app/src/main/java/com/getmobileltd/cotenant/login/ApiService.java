package com.getmobileltd.cotenant.login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("auth/login")
    Call<LoginResponse> startLogin(@Body LoginBody loginBody);


}
