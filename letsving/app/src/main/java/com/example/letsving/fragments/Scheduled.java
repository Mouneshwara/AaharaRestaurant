package com.example.letsving.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.letsving.R;
import com.example.letsving.adapter.MeetingAdapter;
import com.example.letsving.model.Meeting;

import java.util.ArrayList;

public class Scheduled extends Fragment {

    MeetingAdapter meetingAdapter;
    ArrayList<Meeting> meetings = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_scheduled,container, false);

        recyclerView = (RecyclerView)v.findViewById(R.id.rv_meeting);

        MeetingData();
        return v;

    }

    private  void MeetingData(){

        Meeting meetinglist = new Meeting ("MEETING NAME","8 FEB 2021 12:30 PM - 1:30 PM","SCAN");
        meetings.add(meetinglist);

        meetings.add(new Meeting("MEETING NAME","8 FEB 2021 12:30 PM - 1:30 PM","SCAN"));
        meetings.add(new Meeting("MEETING NAME","8 FEB 2021 12:30 PM - 1:30 PM","SCAN"));

        meetings.add(new Meeting("MEETING NAME","8 FEB 2021 12:30 PM - 1:30 PM","SCAN"));



        meetingAdapter = new MeetingAdapter(getContext(),meetings);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(meetingAdapter);
    }


}
