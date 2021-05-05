package com.example.vku.api;

import com.example.vku.model.curr;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://api.fpt.ai/hmi/tts/v5/api-key")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService.class);
   @POST("hmi/tts/v5/api-key")
    Call<curr> send(@Body curr cuu);

}
