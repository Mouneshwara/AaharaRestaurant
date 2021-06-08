package com.example.letsving;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.letsving.fragments.Other;
import com.example.letsving.fragments.Scheduled;
import com.google.android.material.tabs.TabLayout;


public class TabActivity extends AppCompatActivity {
    TabLayout tab;
    ViewPager viewPager;
    View indicator;
    int indiactorWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        tab = findViewById(R.id.tab);
        viewPager=findViewById(R.id.viewPager);
        indicator= findViewById(R.id.indicator);
        init();
    }

    private void init(){
        MediaFilesTabFragmantAdapter mediaFilesTabFragmantAdapter = new MediaFilesTabFragmantAdapter(getSupportFragmentManager());
        mediaFilesTabFragmantAdapter.addFragment(new Scheduled(),"SCHEDULED");
        mediaFilesTabFragmantAdapter.addFragment(new Other(),"OTHER");
        /*mediaFilesTabFragmantAdapter.addFragment(new Other(),"MOTHER");*/

        viewPager.setAdapter(mediaFilesTabFragmantAdapter);
        tab.setupWithViewPager(viewPager);
        //Determine indicator width at runtime
       tab.post(new Runnable() {
            @Override
            public void run() {
                indiactorWidth = tab.getWidth() / tab.getTabCount();

                //Assign new width
                FrameLayout.LayoutParams indicatorParams = (FrameLayout.LayoutParams) indicator.getLayoutParams();
                indicatorParams.width = indiactorWidth;
                indicator.setLayoutParams(indicatorParams);
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) indicator.getLayoutParams();

                //Multiply positionOffset with indicatorWidth to get translation
                float translationOffset = (positionOffset + position) * indiactorWidth;
                params.leftMargin = (int) translationOffset;
                indicator.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}