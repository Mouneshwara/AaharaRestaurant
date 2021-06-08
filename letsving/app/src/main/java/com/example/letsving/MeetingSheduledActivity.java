package com.example.letsving;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MeetingSheduledActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView onBackPress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_sheduled);
        onBackPress = (ImageView)findViewById(R.id.iv_onBackPress);
        onBackPress.setOnClickListener(this);
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