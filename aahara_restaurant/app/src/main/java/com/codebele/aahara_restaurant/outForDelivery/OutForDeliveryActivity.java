package com.codebele.aahara_restaurant.outForDelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.codebele.aahara_restaurant.R;
import com.codebele.aahara_restaurant.SessionManager.UserSessionManager;
import com.codebele.aahara_restaurant.networkUtils.Api;
import com.codebele.aahara_restaurant.networkUtils.ApiClient;
import com.codebele.aahara_restaurant.outForDelivery.Modle.OutForDeiveryModle;
import com.codebele.aahara_restaurant.outForDelivery.adapter.OutForDeliveryAdapter;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OutForDeliveryActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.rv_outForDeliveryList)
    RecyclerView rvOrderList;
    OutForDeliveryAdapter outForDeliveryAdapter;

    private ArrayList<OutForDeiveryModle.Datum> listofOrders = new ArrayList<>();
    @BindView(R.id.ivOnBackPress)
    ImageView ivOnBackPress;

    ProgressDialog loading;
    String access_token = "";
    UserSessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_for_delivery);
        ButterKnife.bind(this);
        session = new UserSessionManager(getApplicationContext());
        access_token = session.getUserDetails().get(UserSessionManager.KEY_accessToken);
        Log.d("accesss_token", access_token.toString());
        //OrderListRecycler();
        ivOnBackPress.setOnClickListener(this);

        callApi();

    }

    private void callApi() {
        Api api = ApiClient.getClient().create(Api.class);
        JsonObject body = new JsonObject();
        loading = ProgressDialog.show(this, "loading", "wait....", false, false);
        Call<OutForDeiveryModle> call = api.getOutForDelivery(access_token);
        call.enqueue(new Callback<OutForDeiveryModle>() {
            @Override
            public void onResponse(Call<OutForDeiveryModle> call, Response<OutForDeiveryModle> response) {
                loading.cancel();
                if (response.body() != null) {

                    OutForDeiveryModle orderListModle = response.body();
                    ArrayList<OutForDeiveryModle.Datum> data = (ArrayList<OutForDeiveryModle.Datum>) orderListModle.getData();
                    outForDeliveryAdapter = new OutForDeliveryAdapter(getApplication(), data);
                    RecyclerView.LayoutManager mlayoutManger = new LinearLayoutManager(getApplicationContext());
                    rvOrderList.setLayoutManager(mlayoutManger);
                    rvOrderList.setAdapter(outForDeliveryAdapter);
                }else {
                    Toast.makeText(getApplicationContext(),"No data found",Toast.LENGTH_LONG).show();


                }

            }

            @Override
            public void onFailure(Call<OutForDeiveryModle> call, Throwable t) {

            }
        });
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivOnBackPress:
                onBackPressed();
                break;
        }
    }
}