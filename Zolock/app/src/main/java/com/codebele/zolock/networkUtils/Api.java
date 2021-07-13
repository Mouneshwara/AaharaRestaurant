package com.codebele.zolock.networkUtils;


import com.codebele.zolock.Model.LoginModel;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {

    @POST("auth/login")
    Call<LoginModel> postLogin(@Body JsonObject body);

}
