package com.codebele.aahara_restaurant.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.codebele.aahara_restaurant.R;
import com.codebele.aahara_restaurant.SideNavigationActivity;
import com.codebele.aahara_restaurant.SessionManager.UserSessionManager;
import com.codebele.aahara_restaurant.Utils.NotificationUtils;
import com.codebele.aahara_restaurant.app.Config;
import com.codebele.aahara_restaurant.networkUtils.Api;
import com.codebele.aahara_restaurant.networkUtils.ApiClient;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.JsonObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.tv_emailerror)
    TextView tvEmailError;
    @BindView(R.id.et_password)
     EditText etPassword;
    String email,deviceToken;
    ProgressDialog loading;
    UserSessionManager session;
    private BroadcastReceiver mRegistrationBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        btLogin.setOnClickListener(this);
        firebse_push_notification();
        session = new UserSessionManager(getApplicationContext());
        if (session.isUserLoggedIn()) {
            Intent intent = new Intent(LoginActivity.this, SideNavigationActivity.class);
            startActivity(intent);
            finish();
        }
     //   validate();
    }

    private void firebse_push_notification() {
        /////firebase setup

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                deviceToken = instanceIdResult.getToken();
                Log.e("deviceToken", deviceToken);
                // Saving reg id to shared preferences
                storeRegIdInPref(deviceToken);

                // sending reg id to your server
                sendRegistrationToServer(deviceToken);
            }
        });


        // txtRegId = (TextView) findViewById(R.id.txt_reg_id);
        //  txtMessage = (TextView) findViewById(R.id.txt_push_message);

        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                // checking for type intent filter
                if (intent.getAction().equals(Config.REGISTRATION_COMPLETE)) {
                    // gcm successfully registered
                    // now subscribe to global topic to receive app wide notifications
                    FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);

                    displayFirebaseRegId();

                } else if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
                    // new push notification is received

                    String message = intent.getStringExtra("message");

                    Toast.makeText(getApplicationContext(), "Push notification: " + message, Toast.LENGTH_LONG).show();

                    // txtMessage.setText(message);
                }
            }
        };

        displayFirebaseRegId();

    }

    private void displayFirebaseRegId() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF, 0);
        String regId = pref.getString("regId", null);

        Log.e("Login Activity", "Firebase reg id: " + regId);

        if (!TextUtils.isEmpty(regId)) {
            // txtRegId.setText("Firebase Reg Id: " + regId);
        } else {
            // txtRegId.setText("Firebase Reg Id is not received yet!");
        }

    }

    private void sendRegistrationToServer(final String token) {
        // sending gcm token to server
        Log.e("Login Activity", "sendRegistrationToServer: " + token);
    }

    private void storeRegIdInPref(String token) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("regId", token);
        editor.commit();
        Log.e("Login Activity", "leaving shared preference: " + token);
    }

    @Override
    protected void onResume() {
        super.onResume();
// register GCM registration complete receiver
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.REGISTRATION_COMPLETE));

        // register new push message receiver
        // by doing this, the activity will be notified each time a new message arrives
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.PUSH_NOTIFICATION));

        // clear the notification area when the app is opened
        NotificationUtils.clearNotifications(getApplicationContext());

    }


/*
    private void validate() {
        TextWatcher tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(!etEmail.isFocused()&&!etEmail.getText().toString().isEmpty()){
                    if (!(android.util.Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches())) {
                        tvEmailError.setVisibility(View.VISIBLE);
                    }

                }
                else {
                    tvEmailError.setVisibility(View.GONE);

                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        etEmail.addTextChangedListener(tw);
    }
*/

    public boolean validate() {
        boolean valid = true;

        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Enter email address");
            valid = false;
        } else {
            etEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            etPassword.setError("Enter Password");
            valid = false;
        } else {
            etPassword.setError(null);
        }

        return valid;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:

                if (validate()){
                    callApi();

                  /*  Intent i = new Intent(this, SaideNavigationActivity.class);
                    startActivity(i);*/
                }else {
                   // Toast.makeText(getApplicationContext(),"Email Or password Mismatch",Toast.LENGTH_SHORT).show();
                }


        }

    }
    private void callApi() {
        Api api = ApiClient.getClient().create(Api.class);
        JsonObject body = new JsonObject();
        body.addProperty("email", etEmail.getText().toString());
        body.addProperty("password", etPassword.getText().toString());
        body.addProperty("deviceToken",deviceToken);

        loading = ProgressDialog.show(this, "Signing In.....", "wait....", false, false);
        Call<LoginModle> call = api.restorentLoginSingin("application/json",body);
        call.enqueue(new Callback<LoginModle>() {
            @Override
            public void onResponse(Call<LoginModle> call, Response<LoginModle> response) {
                loading.cancel();
                    //Boolean msg=loginBean.getStatus();

                    if(response.code() == 200)
                    {
                        LoginModle loginBean = response.body();

                        List<LoginModle.Datum>data=loginBean.getData();
                        for (int i=0;i<data.size();i++)
                        {
                            session.createUserLoginSession(data.get(i).getRestuarantId());
                            session.createRestaurantName(data.get(i).getRestaurantName());
                            session.createEmail(data.get(i).getEmail());
                            session.createMobile(data.get(i).getMobile());
                            session.createSkRestaurantId(data.get(i).getSkRestaurantId());

                        }

                        Intent i = new Intent(getApplicationContext(), SideNavigationActivity.class);
                        startActivity(i);
                        //Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
                    }else if(response.code()==401)
                    {
                        Toast.makeText(getApplicationContext(),"Email Or password Mismatch",Toast.LENGTH_LONG).show();
                    }
                }



            @Override
            public void onFailure(Call<LoginModle> call, Throwable t) {
                loading.cancel();
                // showToast(getApplicationContext(), t.toString());

            }
        });

    }

}