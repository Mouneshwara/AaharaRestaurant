package com.codebele.aahara_restaurant.outForDelivery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codebele.aahara_restaurant.R;
import com.codebele.aahara_restaurant.outForDelivery.Modle.OutForDeiveryModle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OutForDeliveryAdapter extends RecyclerView.Adapter<OutForDeliveryAdapter.MyViewHolder> {
    Context mCotext;
    private ArrayList<OutForDeiveryModle.Datum> orderlist = new ArrayList<>();
    private ArrayList<OutForDeiveryModle.Item> items = new ArrayList<>();

    public OutForDeliveryAdapter(Context mCotext, ArrayList<OutForDeiveryModle.Datum> orderlist) {
        this.mCotext = mCotext;
        this.orderlist = orderlist;
    }

    @NonNull
    @Override
    public OutForDeliveryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_order_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OutForDeliveryAdapter.MyViewHolder holder, int position) {
        String List_name;
        List<String> data=new ArrayList<>();
        ArrayList<OutForDeiveryModle.Item> items = new ArrayList<>();
        OutForDeiveryModle.Datum orders = orderlist.get(position);
        items= (ArrayList<OutForDeiveryModle.Item>) orders.getItem();
        for(int i=0;i<items.size();i++)
        {
//            s = TextUtils.join(",", Collections.singleton());
            data.add(" "+items.get(i).getItemName());

        }
        List_name = data.toString().replace("[", "")
                .replace("]", " ").replace(" , ", "  ,");
        holder.tvHotelName.setText(orders.getFullName());
        holder.tvOrderPlace.setText(orders.getOrderStatus());
        holder.tvLocation.setText(orders.getAddress());
        holder.tvAmount.setText(orders.getActualPrice());
        holder.tvDate.setText(orders.getCreatedDate());
        holder.tvItemsName.setText(List_name);


    }

    @Override
    public int getItemCount() {
        return orderlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_hotelName)
        TextView tvHotelName;
        @BindView(R.id.tv_location)
        TextView tvLocation;
        @BindView(R.id.tv_amount)
        TextView tvAmount;
        @BindView(R.id.tv_ordresName)
        TextView tvItemsName;
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.tv_delivered)
        TextView tvOrderPlace;
        /*@BindView(R.id.tv_quantity)
        TextView tvQuantity;*/
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
