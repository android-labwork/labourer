package com.aitekteam.developer.labourer.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aitekteam.developer.labourer.Models.AchievementModel;
import com.aitekteam.developer.labourer.R;

import java.util.ArrayList;

public class AchievementAdapter extends RecyclerView.Adapter<AchievementAdapter.ViewHolder> {
    private ArrayList<AchievementModel> items;

    public AchievementAdapter(ArrayList<AchievementModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_item_list_achievement,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AchievementModel item = this.items.get(position);
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
        ImageView item_icon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.item_title = itemView.findViewById(R.id.item_title);
            this.item_location = itemView.findViewById(R.id.item_location);
            this.item_point = itemView.findViewById(R.id.item_point);
            this.item_icon = itemView.findViewById(R.id.item_icon);
        }
    }
}
