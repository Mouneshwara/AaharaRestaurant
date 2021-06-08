package com.example.letsving;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RoomNameActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView onBackPress;
    private ImageView ivGoogleMeet,ivZoom,ivMsTeams,ivWebex,ivBluejens;
    String result =" ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_name);
        onBackPress = (ImageView)findViewById(R.id.iv_onBackPress);
        onBackPress.setOnClickListener(this);

        ivBluejens = (ImageView)findViewById(R.id.iv_bluejens);
        ivGoogleMeet = (ImageView)findViewById(R.id.iv_googleMeet);
        ivZoom = (ImageView)findViewById(R.id.iv_zoom);
        ivMsTeams = (ImageView)findViewById(R.id.iv_msTeams);
        ivWebex = (ImageView)findViewById(R.id.iv_webex);


        ivBluejens.setOnClickListener(this);
        ivGoogleMeet.setOnClickListener(this);
        ivZoom.setOnClickListener(this);
        ivMsTeams.setOnClickListener(this);
        ivWebex.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

   /* public void nextActivity(){
        Intent intent = new Intent(this,MeetingJoinActivity.class);
        intent.putExtra("meeting", result);
        startActivity(intent);
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_onBackPress:
                onBackPressed();
                break;
            case R.id.iv_zoom:
                result="zoom";
                Intent intent = new Intent(this,MeetingJoinActivity.class);
                intent.putExtra("meeting", result);
                startActivity(intent);
                break;
            case R.id.iv_webex:
                result="webex";
                Intent intent1 = new Intent(this,MeetingJoinActivity.class);
                intent1.putExtra("meeting", result);
                startActivity(intent1);
                break;
            case R.id.iv_msTeams:
                result="msteams";
                Intent i = new Intent(this,MeetingJoinActivity.class);
                i.putExtra("meeting", result);
                startActivity(i);
                break;
            case R.id.iv_googleMeet:
                result="google";
                Intent j = new Intent(this,MeetingJoinActivity.class);
                j.putExtra("meeting", result);
                startActivity(j);
                break;
            case R.id.iv_bluejens:
                result="bluejens";
                Intent k = new Intent(this,MeetingJoinActivity.class);
                k.putExtra("meeting", result);
                startActivity(k);
                break;

        }
    }
}