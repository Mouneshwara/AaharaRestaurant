package com.example.letsving.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.letsving.R;
import com.example.letsving.ScannerActivity;
import com.example.letsving.fragments.Scheduled;
import com.example.letsving.model.Meeting;

import java.util.ArrayList;
import java.util.List;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.MyViewHoldder>  {
    private Context mContext;
    private List<Meeting> meetingList;

    public MeetingAdapter(Context mContext,ArrayList<Meeting> meetingList) {
        this.mContext = mContext;
        this.meetingList=meetingList;

    }

    @NonNull
    @Override
    public MeetingAdapter.MyViewHoldder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_meeting, parent, false);

        return new MyViewHoldder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingAdapter.MyViewHoldder holder, int position) {
        Meeting meeting= meetingList.get(position);
        holder.time.setText(meeting.getMeetingName());
        holder.time.setText(meeting.getTime());
        holder.scan.setText(meeting.getScan());
        holder.scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ScannerActivity.class);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return meetingList.size();
    }

    public class MyViewHoldder extends RecyclerView.ViewHolder {
        public TextView title, time,scan;

        public MyViewHoldder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            time = (TextView) itemView.findViewById(R.id.tv_time);
            scan = (TextView)itemView.findViewById(R.id.tv_scan);


        }
    }
}
