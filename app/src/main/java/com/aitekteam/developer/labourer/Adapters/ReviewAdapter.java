package com.aitekteam.developer.labourer.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aitekteam.developer.labourer.Models.ReviewModel;
import com.aitekteam.developer.labourer.R;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {
    private ArrayList<ReviewModel> items;

    public ReviewAdapter(ArrayList<ReviewModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_list_review,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ReviewModel item = this.items.get(position);
        holder.item_title.setText(item.getTitle());
        holder.item_description.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_title, item_description;
        ImageView item_icon;
        LinearLayout item_point_container;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.item_title = itemView.findViewById(R.id.item_title);
            this.item_icon = itemView.findViewById(R.id.item_icon);
            this.item_description = itemView.findViewById(R.id.item_description);
            this.item_point_container = itemView.findViewById(R.id.item_point_container);
        }
    }
}
