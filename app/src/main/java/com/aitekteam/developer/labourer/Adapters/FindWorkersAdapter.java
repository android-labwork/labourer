package com.aitekteam.developer.labourer.Adapters;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aitekteam.developer.labourer.Models.WorkerModel;
import com.aitekteam.developer.labourer.R;

import java.util.ArrayList;

public class FindWorkersAdapter extends RecyclerView.Adapter<FindWorkersAdapter.ViewHolder> {
    private ArrayList<WorkerModel> items;
    private WorkerSelectedHandler handler;

    public FindWorkersAdapter(ArrayList<WorkerModel> items, WorkerSelectedHandler handler) {
        this.items = items;
        this.handler = handler;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_item_list_find_worker,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WorkerModel item = this.items.get(position);
        holder.item_review_point.setText(String.valueOf(item.getAvg_review()) + ".0");
        holder.item_skills.setText(convertSkills(item.getSkills()));
        holder.item_title.setText(item.getName());

        holder.bind(item, position, this.handler);
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    private String convertSkills(ArrayList<String> skills) {
        return "Keahlian : " + TextUtils.join(", ", skills);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        ImageView item_icon;
        TextView item_title, item_skills, item_status, item_review_point;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            item_icon = itemView.findViewById(R.id.item_icon);
            item_title = itemView.findViewById(R.id.item_title);
            item_skills = itemView.findViewById(R.id.item_skills);
            item_status = itemView.findViewById(R.id.item_status);
            item_review_point = itemView.findViewById(R.id.item_review_point);
        }

        void bind(final WorkerModel item, final int position, final WorkerSelectedHandler handler){
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    handler.onSelectedItem(item, position);
                }
            });
        }
    }

    public interface WorkerSelectedHandler {
        void onSelectedItem(WorkerModel item, int position);
    }
}
