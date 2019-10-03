package com.aitekteam.developer.labourer.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aitekteam.developer.labourer.Models.SkillsModel;
import com.aitekteam.developer.labourer.R;

import java.util.ArrayList;

public class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.ViewHolder> {
    private ArrayList<SkillsModel> items;

    public SkillsAdapter(ArrayList<SkillsModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_item_list_skills,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SkillsModel item = this.items.get(position);
        holder.item_title.setText(item.getTitle());
        holder.item_level.setText("Level " + String.valueOf(item.getLevel()));
        holder.item_point.setText(String.valueOf(item.getPoint()) + " / " + String.valueOf(300));
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_title, item_level, item_point;
        ImageView item_icon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.item_title = itemView.findViewById(R.id.item_title);
            this.item_level = itemView.findViewById(R.id.item_level);
            this.item_point = itemView.findViewById(R.id.item_point);
            this.item_icon = itemView.findViewById(R.id.item_icon);
        }
    }
}
