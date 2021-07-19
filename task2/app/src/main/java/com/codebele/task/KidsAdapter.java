package com.codebele.task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KidsAdapter extends RecyclerView.Adapter<KidsAdapter.MyViewHolder> {
    Context context;
    ArrayList<KidsModle.Category> categories =new ArrayList<>();
    MainActivity mainActivity;
    String catId;
    CallApi callApi;
    public KidsAdapter(Context context, ArrayList<KidsModle.Category> categories,CallApi callApi) {
        this.context = context;
        this.categories = categories;
        this.callApi = callApi;
    }

    @NonNull
    @Override
    public KidsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tags_list_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KidsAdapter.MyViewHolder holder, int position) {
            KidsModle.Category category= categories.get(position);
            holder.tvCat.setText(category.getCategoryName());
            catId = category.getId();
            holder.tvCat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //mainActivity.newmethod(catId);
                    callApi.CallImage(catId);
                }
            });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        Button tvCat;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCat = (Button)itemView.findViewById(R.id.tv_catId);
        }
    }
}
