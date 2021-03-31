package com.codebele.aahara_restaurant.networkUtils;


import com.codebele.aahara_restaurant.dashboard.DashBoardModle;
import com.codebele.aahara_restaurant.login.LoginModle;
import com.codebele.aahara_restaurant.newOrders.modle.OrderListModle;
import com.codebele.aahara_restaurant.outForDelivery.Modle.OutForDeiveryModle;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {
    @POST("RestaurantsignIn")
    Call<LoginModle> restorentLoginSingin(@Header("Content-Type") String content_typ,@Body JsonObject body);

    @POST("getordersbyrestId")
    Call<OrderListModle>getOrderList(@Header("Accesstoken") String access_token);

    @POST("OutForDelivery")
    Call<OutForDeiveryModle>getOutForDelivery(@Header("Accesstoken") String access_token);

    @GET("countAll")
    Call<DashBoardModle>getcountAll(@Header("Accesstoken") String access_token/*,@Header("typevalue") String typevalue*/);

}
