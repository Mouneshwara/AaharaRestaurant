package com.codebele.zolock;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.codebele.zolock.Model.LoginModel;
import com.codebele.zolock.networkUtils.Api;
import com.codebele.zolock.networkUtils.ApiClient;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    TextView tv_zlock, tv_by, tv_ele;
    EditText et_mobileno;
    String mobileno;
    private int MY_PERMISSIONS = 1;
    LinearLayout ll_byelementure;
    Animation animFadeIn, animRighttoleft;
    Button bt_submit;
    ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initalization();
        if (ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(LoginActivity.this, new String[]{android.Manifest.permission.SEND_SMS,
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.INTERNET, android.Manifest.permission.ACCESS_COARSE_LOCATION,
                    android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.CAMERA,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS);
        }

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }

    private void initalization() {
        et_mobileno = (EditText) findViewById(R.id.et_mobileno);
        bt_submit = (Button) findViewById(R.id.bt_submit);
        ll_byelementure = (LinearLayout) findViewById(R.id.ll_byelementure);
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        animRighttoleft = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        ll_byelementure.startAnimation(animRighttoleft);
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (validate()) {
//                    callLoginapi();
//                startActivity(new Intent(getApplicationContext(),OtpActivity.class));
                overridePendingTransition(R.anim.slide_in_right,  R.anim.slide_in_right);
//                }

            }
        });
    }
    private void callApi() {
        Api api = ApiClient.getClient().create(Api.class);
        JsonObject body = new JsonObject();
        body.addProperty("mobile",et_mobileno.getText().toString());
        loading = ProgressDialog.show(this, "Signing In.....", "wait....", false, false);
        Call<LoginModel> call = api.postLogin(body);
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                loading.cancel();
                if (response.isSuccessful()) {
//                    Intent i = new Intent(SignInActivity.this, CopyPoseActivity.class);
//                    startActivity(i);
//                    finish();
                } else {
                    try {
                        String error_message = response.errorBody().string();
                        JSONObject jObjError = new JSONObject(error_message);
                        if ((jObjError.getString("message")).equals("Invalid username/password"))
                        {
//                            binding.emailerror1.setVisibility(View.VISIBLE);
//                            binding.emailerror1.setText(jObjError.getString("message"));
                        }
                        else {
//                            binding.emailerror1.setVisibility(View.VISIBLE);
//                            binding.emailerror1.setText(jObjError.getString("message"));
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();


                    } catch (IOException e) {
                        e.printStackTrace();

                    }

                }
            }
            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                loading.cancel();
                // showToast(getApplicationContext(), t.toString());

            }
        });

    }




}