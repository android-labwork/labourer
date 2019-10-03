package com.aitekteam.developer.labourer.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aitekteam.developer.labourer.Models.LevelModel;
import com.aitekteam.developer.labourer.R;

import java.util.ArrayList;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.ViewHolder> {
    private ArrayList<LevelModel> items;

    public LevelAdapter(ArrayList<LevelModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_item_list_exp,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LevelModel item = this.items.get(position);
        holder.item_title.setText(item.getTitle());
        holder.item_location.setText(item.getLocation());
        holder.item_point.setText(String.valueOf(item.getPoint()) + " Point");
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_title, item_location, item_point;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.item_title = itemView.findViewById(R.id.item_title);
            this.item_location = itemView.findViewById(R.id.item_location);
            this.item_point = itemView.findViewById(R.id.item_point);
        }
    }
}
