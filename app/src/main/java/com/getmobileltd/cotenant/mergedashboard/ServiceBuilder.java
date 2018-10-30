package com.getmobileltd.cotenant.mergedashboard;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {
    private static final String BASE_URL = "http://192.168.43.96:8000/api/v1/";

    //Create Logger
    private static HttpLoggingInterceptor logger = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    //Create OkHttpClient
    private static OkHttpClient.Builder okHttp = new OkHttpClient.Builder().addInterceptor(logger);

    private static Retrofit.Builder builder =
            new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    public static <S> S buildService(Class<S> serviceType) {
        return retrofit.create(serviceType);
    }

}
