package com.getmobileltd.cotenant.interest;

import android.content.Context;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client{
   // Context context;

   /* public static final String BASE_URL = "http://api.themoviedb.org/3/";
    public static Retrofit retrofit = null;


    public  Retrofit getClient(Context context) {
     //   this.context = context;
        int cachesize = 10 * 1024 * 1024;
        Cache cache = new Cache(context.getCacheDir(),cachesize);

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache).build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();

            }
            return retrofit;
    }*/
}
