package com.codebele.aahara_restaurant.newOrders;

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
import com.codebele.aahara_restaurant.newOrders.adapters.NewOrderAdapter;
import com.codebele.aahara_restaurant.newOrders.modle.OrderListModle;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewOrdersActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.rv_neworderList)
    RecyclerView rvNewOrders;
    NewOrderAdapter newOrderAdapter;
    //private ArrayList<NewOrderModle> newOrderList = new ArrayList<>();

    private ArrayList<OrderListModle.Order> listofOrders = new ArrayList<>();
    @BindView(R.id.ivOnBackPress)
    ImageView ivOnBackPress;

    ProgressDialog loading;
    String access_token = "";
    UserSessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_orders);
        ButterKnife.bind(this);
        session = new UserSessionManager(getApplicationContext());
        access_token = session.getUserDetails().get(UserSessionManager.KEY_accessToken);
        Log.d("accesss_token", access_token.toString());
        //OrderListRecycler();
        ivOnBackPress.setOnClickListener(this);

        callApi();
    }

    private void OrderListRecycler(List<OrderListModle.Order> orderlist){
       /* newOrderList.add(new NewOrderModle("Mounesh","Ballary","₹ 333","Chiken Biryani","16/03/2021 at 11:00"));
        newOrderList.add(new NewOrderModle("Sathish","Yadgiri","₹ 335","Chiken Biryani","16/03/2021 at 11:00"));
        newOrderList.add(new NewOrderModle("Karthik","Raichur","₹ 393","Chiken Biryani","16/03/2021 at 11:00"));
        newOrderList.add(new NewOrderModle("Nagaveni","Ballary","₹ 400","Chiken Biryani","16/03/2021 at 11:00"));
*/        newOrderAdapter = new NewOrderAdapter(this,listofOrders);
        RecyclerView.LayoutManager mlayoutManger = new LinearLayoutManager(getApplicationContext());
        rvNewOrders.setLayoutManager(mlayoutManger);
        rvNewOrders.setAdapter(newOrderAdapter);
    }

    private void callApi() {
        Api api = ApiClient.getClient().create(Api.class);
        JsonObject body = new JsonObject();
        loading = ProgressDialog.show(this, "loading", "wait....", false, false);
        Call<OrderListModle> call = api.getOrderList(access_token);
        call.enqueue(new Callback<OrderListModle>() {
            @Override
            public void onResponse(Call<OrderListModle> call, Response<OrderListModle> response) {
                loading.cancel();
                if (response.body() != null){
                    OrderListModle orderListModle=response.body();
                    ArrayList<OrderListModle.Order> data= (ArrayList<OrderListModle.Order>) orderListModle.getData();
                    newOrderAdapter = new NewOrderAdapter(getApplication(),data);
                    RecyclerView.LayoutManager mlayoutManger = new LinearLayoutManager(getApplicationContext());
                    rvNewOrders.setLayoutManager(mlayoutManger);
                    rvNewOrders.setAdapter(newOrderAdapter);

                }else {
                    Toast.makeText(getApplicationContext(),"No data found",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<OrderListModle> call, Throwable t) {

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