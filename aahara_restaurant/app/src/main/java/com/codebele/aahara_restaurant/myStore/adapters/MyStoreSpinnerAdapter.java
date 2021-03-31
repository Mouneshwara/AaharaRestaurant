package com.codebele.aahara_restaurant.myStore.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.codebele.aahara_restaurant.myStore.modle.MyStore;

import java.util.ArrayList;

public class MyStoreSpinnerAdapter extends ArrayAdapter<MyStore> {
    private Context context;
    private ArrayList<MyStore> issueList;

    public MyStoreSpinnerAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<MyStore> issueList) {
        super(context, resource);
        this.context = context;
        this.issueList = issueList;
    }

    public int getCount() {
        return issueList.size();
    }

    public MyStore getItem(int position) {
        return issueList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // I created a dynamic TextView here, but you can reference your own  custom layout for each spinner item
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setText(issueList.get(position).getIssue_type());
        // And finally return your dynamic (or custom) view for each spinner item
        return label;
    }

    // And here is when the "chooser" is popped up
    // Normally is the same view, but you can customize it if you want
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setText(issueList.get(position).getIssue_type());
        return label;
    }
}
