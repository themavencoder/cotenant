package com.getmobileltd.cotenant.registration.apppinmvp;

public class ApiUtils {

    private ApiUtils() {}
    public static ApiService getApiService() {
        return  Client.getClient().create(ApiService.class);
    }
}
