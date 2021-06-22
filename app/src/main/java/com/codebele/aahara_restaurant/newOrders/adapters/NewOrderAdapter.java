package com.codebele.aahara_restaurant.newOrders.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codebele.aahara_restaurant.R;
import com.codebele.aahara_restaurant.myStore.modle.MyStore;
import com.codebele.aahara_restaurant.newOrders.modle.OrderListModle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewOrderAdapter extends RecyclerView.Adapter<NewOrderAdapter.NewOrderViewHolder> {
    Context mCotext;
    // private ArrayList<NewOrderModle> newOrderList = new ArrayList<>();
    AmountSpinner amountSpinner;
    private ArrayList<MyStore> amount = new ArrayList<>();

    private ArrayList<OrderListModle.Order> orderlist = new ArrayList<>();
    private ArrayList<OrderListModle.Item> items = new ArrayList<>();

    public NewOrderAdapter(Context mCotext, ArrayList<OrderListModle.Order> orderlist) {
        this.mCotext = mCotext;
        this.orderlist = orderlist;
    }

    @NonNull
    @Override
    public NewOrderAdapter.NewOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_order_list, parent, false);

        return new NewOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewOrderAdapter.NewOrderViewHolder holder, int position) {
        //NewOrderModle newOrderModle = newOrderList.get(position);
        String List_name;
        List<String> data=new ArrayList<>();
        ArrayList<OrderListModle.Item> items = new ArrayList<>();
        OrderListModle.Order orders = orderlist.get(position);
        items= (ArrayList<OrderListModle.Item>) orders.getItem();
        for(int i=0;i<items.size();i++)
        {
//            s = TextUtils.join(",", Collections.singleton());
            data.add(" "+items.get(i).getItemName());

        }
        List_name = data.toString().replace("[", "")
                .replace("]", "").replace(", ", ",  ");
        holder.tvHotelName.setText(orders.getFullName());
        holder.tvOrderPlace.setText(orders.getOrderStatus());
        holder.tvLocation.setText(orders.getAddress());
        holder.tvAmount.setText(orders.getPrice());
        holder.tvDate.setText(orders.getCreatedDate());
        holder.tvItemsName.setText(List_name);
//        OrderListModle.Item item= items.get(position);



    }

    @Override
    public int getItemCount() {
        return orderlist.size();
    }

    public class NewOrderViewHolder extends RecyclerView.ViewHolder /*implements AdapterView.OnItemSelectedListener*/ {
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
       /* @BindView(R.id.amountSpinner)
        Spinner spinner;*/

        public NewOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
           /* initList();
            setSpinnerAdapter();*/

        }

       /* private void setSpinnerAdapter() {
            amountSpinner = new AmountSpinner(mCotext, R.layout.layout_spinner, amount);
            spinner.setAdapter(amountSpinner);
            spinner.setOnItemSelectedListener(this);

        }

        private void initList() {
            amount.clear();
            amount.add(new MyStore("0", "550"));
            amount.add(new MyStore("1", "520"));
            amount.add(new MyStore("2", "100"));
            amount.add(new MyStore("3", "84"));
        }
*/
      /*  @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }
*/
       /* @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }*/
    }
}
