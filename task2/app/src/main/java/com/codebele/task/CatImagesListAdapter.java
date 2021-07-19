package com.codebele.task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.codebele.task.networkUtils.ApiClient.BASE_URL;

public class CatImagesListAdapter  extends RecyclerView.Adapter<CatImagesListAdapter.MyviewHolder> {
    Context context;
    ArrayList<ImagesModle.HomePage> imagesList = new ArrayList<>();

    public CatImagesListAdapter(Context context, ArrayList<ImagesModle.HomePage> imagesList) {
        this.context = context;
        this.imagesList = imagesList;
    }

    @NonNull
    @Override
    public CatImagesListAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.images_list, parent, false);
        return new CatImagesListAdapter.MyviewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull CatImagesListAdapter.MyviewHolder holder, int position) {
        ImagesModle.HomePage images = imagesList.get(position);
        Picasso.get().load(BASE_URL+images.getCoverImage())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.iv_images);
        }
    }
}
