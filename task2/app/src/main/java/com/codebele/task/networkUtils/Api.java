package com.codebele.task.networkUtils;
import com.codebele.task.ImagesModle;
import com.codebele.task.KidsModle;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("services/categories?API-KEY=9876543&lang=en")
    Call<KidsModle> GetCat();
    @GET("services/home_page?API-KEY=9876543&lang=en&category_id=1&sub_category_id=&post_type=&city_id=&latitude=&longitude=&order_by=")
//   @GET("services/home_page?API-KEY=9876543&lang=en&category_id={1}&sub_category_id=&post_type=&city_id=&latitude=&longitude=&order_by=")
     Call<ImagesModle> GetImagesList(
             @Query("cat_id") String cat_id
           /*@Query("sub_cat_id") String sub_cat_id,
             @Query("post_type") String post_type,
             @Query("city_id") String city_id,
             @Query("latitude") String latitude,
             @Query("longitude") String longitude,
             @Query("order_by") String order_by*/
             );
}
