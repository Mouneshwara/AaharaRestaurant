package com.example.letsving;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MeetingJoinActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView,onBackPress,imhZoom,imgGoogle,imgBluejens,imgMsteams,imgWebX;

    private String type="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_join);

        imageView = (ImageView)findViewById(R.id.iv_joingGoogle);
        onBackPress = (ImageView)findViewById(R.id.iv_onBackPress);
        imhZoom = (ImageView)findViewById(R.id.iv_joingZoom);
        imgGoogle = (ImageView)findViewById(R.id.iv_joingGoogle);
        imgBluejens = (ImageView)findViewById(R.id.iv_joingbluejens);
        imgMsteams = (ImageView)findViewById(R.id.iv_joingMsmeeting);
        imgWebX = (ImageView)findViewById(R.id.iv_joingWebex);



        onBackPress.setOnClickListener(this);
        if (getIntent().getExtras()!=null){
            type=getIntent().getExtras().getString("meeting");
  //        binding.tvToolBar.setText(personText);
        }

        if (type.equals("zoom")){
            imageView.setImageResource(R.drawable.zoom);

        }else if(type.equals("google")){
            imageView.setImageResource(R.drawable.googlemeet);

        }else if ((type.equals("webex"))){
            imageView.setImageResource(R.drawable.webex);

        }else if (type.equals("msteams")){
            imageView.setImageResource(R.drawable.msteams);

        }else if (type.equals("bluejens")){
            imageView.setImageResource(R.drawable.bluejens);

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_onBackPress:
                onBackPressed();
                break;
        }
    }
}