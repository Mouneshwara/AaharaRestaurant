package com.codebele.aahara_restaurant.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.codebele.aahara_restaurant.R;
import com.codebele.aahara_restaurant.SessionManager.UserSessionManager;
import com.codebele.aahara_restaurant.networkUtils.Api;
import com.codebele.aahara_restaurant.networkUtils.ApiClient;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {

    @BindView(R.id.tv_noOfDeliverys)
    TextView tvNumberOfDelivery;
    @BindView(R.id.tv_noOfCancle)
    TextView tvNumberOfCancle;


    ProgressDialog loading;
    String access_token = "";
    UserSessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        session = new UserSessionManager(getApplicationContext());
        access_token = session.getUserDetails().get(UserSessionManager.KEY_accessToken);
        Log.d("accesss_token", access_token.toString());
        callApi();
    }

    private void callApi() {
        Api api = ApiClient.getClient().create(Api.class);
        JsonObject body = new JsonObject();
        loading = ProgressDialog.show(this, "loading", "wait....", false, false);
        Call<DashBoardModle> call = api.getcountAll(access_token);
        call.enqueue(new Callback<DashBoardModle>() {
            @Override
            public void onResponse(Call<DashBoardModle> call, Response<DashBoardModle> response) {
                loading.cancel();
                if (response.body() != null) {
                    DashBoardModle dashBoardModle = response.body();
                    ArrayList<DashBoardModle.CountItems> data = (ArrayList<DashBoardModle.CountItems>) dashBoardModle.getData();
                    for (int i=0;i<data.size();i++) {
                        tvNumberOfCancle.setText(String.valueOf(data.get(i).getCountCancelled()));
                        tvNumberOfDelivery.setText(String.valueOf(data.get(i).getCountDelivered()));

                    }

                }else {
                    Toast.makeText(getApplicationContext(),"No data found",Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<DashBoardModle> call, Throwable t) {

            }
        });
    }

}