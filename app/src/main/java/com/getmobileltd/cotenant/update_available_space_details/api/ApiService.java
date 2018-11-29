package com.getmobileltd.cotenant.update_available_space_details.api;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {


    @POST("interests/create")
    Call<CreateInterestResponse> getInterest(@Header("Authorization") String value, @Query("cotenant_id") int cotenant_id,
                                             @Query("property_id") int property_id);

    @POST("interests/delete")
    Call<DeleteInterestResponse> deleteInterest(@Header("Authorization") String value, @Query("cotenant_id") int id, @Query("property_id") int property_id);

}
