package com.codebele.aahara_restaurant.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.codebele.aahara_restaurant.R;
import com.codebele.aahara_restaurant.SessionManager.UserSessionManager;
import com.codebele.aahara_restaurant.dashboard.DashBoardModle;
import com.codebele.aahara_restaurant.networkUtils.Api;
import com.codebele.aahara_restaurant.networkUtils.ApiClient;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoardFragment  extends Fragment {
    @BindView(R.id.tv_noOfDeliverys)
    TextView tvNumberOfDelivery;
    @BindView(R.id.tv_noOfCancle)
    TextView tvNumberOfCancle;
    @BindView(R.id.tv_on_the_way)
    TextView tvpickedup;
    @BindView(R.id.tv_placed_orders)
    TextView tvplacedOrders;

    ProgressDialog loading;
    String access_token = "";
    UserSessionManager session;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dashboard,container,false);
        ButterKnife.bind(this,view);
        session = new UserSessionManager(getContext());
        access_token = session.getUserDetails().get(UserSessionManager.KEY_accessToken);
        Log.d("accesss_token", access_token.toString());
        callApi();
        return view;
    }
    private void callApi() {
        Api api = ApiClient.getClient().create(Api.class);
        JsonObject body = new JsonObject();
        loading = ProgressDialog.show(getContext(), "loading", "wait....", false, false);
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
                        tvpickedup.setText(String.valueOf(data.get(i).getCountPickedup()));
                        tvplacedOrders.setText(String.valueOf(data.get(i).getCountPlaced()));
                    }
                }else {
                    Toast.makeText(getContext(),"No data found",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<DashBoardModle> call, Throwable t) {

            }
        });
    }

}
