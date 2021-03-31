package com.codebele.aahara_restaurant.networkUtils;

import com.codebele.aahara_restaurant.App;
import com.codebele.aahara_restaurant.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.HttpException;

public class ApiUtils {

    public static String getError(HttpException error) throws IOException {
        JSONObject errorBody = null;
        String errorMessage = App.getpInstance().getString(R.string.something_unexpected);
        try {
            errorBody = new JSONObject(error.response().errorBody().string());
            if (errorBody != null) {
               /* if (errorBody.has(MESSAGE)) {
                    return errorBody.get(MESSAGE).toString();
                }*/
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return errorMessage;
    }


    public static String getErrorAppDescription(HttpException error) throws IOException {
        JSONObject errorBody = null;
        String errorMessage = App.getpInstance().getString(R.string.something_unexpected);
        try {
            errorBody = new JSONObject(error.response().errorBody().string());
            if (errorBody != null) {
                /*if (errorBody.has(ERRORDESCRIPTION)) {
                    return errorBody.get(ERRORDESCRIPTION).toString();
                }*/
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return errorMessage;
    }
}
