package com.example.task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context mContext;

    ArrayList<Modle> itemList = new ArrayList<>();

    public Adapter(Context mContext, ArrayList<Modle> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_email_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
      //  holder.tvEmail.setText(itemList.get(position).toString());
            Modle modle = itemList.get(position);
            holder.tvEmail.setText(modle.getEmail());
            holder.tvNumber.setText(modle.getNumber());


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvEmail,tvNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEmail=(TextView)itemView.findViewById(R.id.tv_email);
            tvNumber=(TextView)itemView.findViewById(R.id.tv_number);

        }
    }
}
