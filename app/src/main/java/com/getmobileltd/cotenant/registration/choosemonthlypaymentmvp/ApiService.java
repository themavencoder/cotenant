package com.getmobileltd.cotenant.registration.choosemonthlypaymentmvp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("cotenants/create")
    Call<TenantResponse> createTenant(@Body TenantBody tenantBody);
}
