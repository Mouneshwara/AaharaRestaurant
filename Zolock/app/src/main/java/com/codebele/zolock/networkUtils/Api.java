package com.codebele.zolock.networkUtils;


import com.codebele.zolock.Model.LoginModel;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {

    @GET("services/categories?API-KEY=9876543&lang=en")
    Call<LoginModel> postLogin(@Body JsonObject body);

}
