package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitApiInterface {
    @POST("users")
    Call<FormRequest> registerUser(@Body FormRequest formRequest);
}
