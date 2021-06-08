package com.example.letsving.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.letsving.MeetingSheduledActivity;
import com.example.letsving.R;
import com.example.letsving.RoomNameActivity;
import com.example.letsving.ScannerActivity;
import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import github.nisrulz.qreader.QRDataListener;
import github.nisrulz.qreader.QREader;
import info.androidhive.barcode.BarcodeReader;

public class Other extends Fragment {
    BarcodeReader barcodeReader;
    SurfaceView mySurfaceView;
    private QREader qrEader;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_other,container, false);
        mySurfaceView = (SurfaceView) v.findViewById(R.id.camera_view);



        // Init QREader
        // ------------
        qrEader = new QREader.Builder(getContext(), mySurfaceView, new QRDataListener() {
            @Override
            public void onDetected(final String data) {
                Log.d("QREader", "Value : " + data);
         /*       text.post(new Runnable() {
                    @Override
                    public void run() {
                      //  text.setText(data);
                    }
                });*/


                Intent intent = new Intent(getContext(), RoomNameActivity.class);
                intent.putExtra("meeting", data);
                Log.e("code",data);
                getActivity().startActivity(intent);
            }
        }).facing(QREader.BACK_CAM)
                .enableAutofocus(true)
                .height(mySurfaceView.getHeight())
                .width(mySurfaceView.getWidth())
                .build();



        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Fragment childFragment = new BarcodeReader();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
       // transaction.replace(R.id., childFragment).commit();

        // -----------------

    }

    @Override
    public void onResume() {
        super.onResume();

        // Init and Start with SurfaceView
        // -------------------------------
        qrEader.initAndStart(mySurfaceView);
        qrEader.start();
    }

    @Override
    public void onPause() {
        super.onPause();

        // Cleanup in onPause()
        // --------------------
        qrEader.releaseAndCleanup();
    }


}
