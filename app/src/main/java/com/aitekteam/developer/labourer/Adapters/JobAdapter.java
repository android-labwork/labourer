package com.aitekteam.developer.labourer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aitekteam.developer.labourer.Models.JobModel;
import com.aitekteam.developer.labourer.R;

import java.util.ArrayList;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.ViewHolder> {

    private ArrayList<JobModel> items;
    private JobSelectedHandler handler;
    private Context context;

    public JobAdapter(ArrayList<JobModel> items, JobSelectedHandler handler) {
        this.items = items;
        this.handler = handler;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_item_list_job,
                parent, false);
        this.context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JobModel item = this.items.get(position);
        holder.bind(item, position, this.handler);

        holder.item_title.setText(item.getTitle());
        holder.item_location.setText(item.getLocation());
        holder.item_status.setText(convertStatus(item.getStatus()));
        holder.item_status.setTextColor(this.context.getResources().getColor(convertColorStatus(item.getStatus())));
        holder.item_icon.setImageResource(convertType(item.getType()));
    }

    private String convertStatus(int status) {
        switch (status) {
            case 1: return "Diajukan";
            case 2: return "Diterima";
            case 3: return "Ditolak";
            case 4: return "Dikerjakan";
            default: return "Selesai";
        }
    }

    private int convertType(int type) {
        if (type == 1) {
            return R.drawable.paint_skill_50;
        }
        return R.drawable.decoration_skill_50;
    }

    private int convertColorStatus(int status) {
        switch (status) {
            case 1: return R.color.colorBlack;
            case 2: return R.color.colorGreen;
            case 3: return R.color.colorRed;
            case 4: return R.color.colorAccent;
            default: return R.color.colorPrimary;
        }
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private View itemView;
        private TextView item_title, item_location, item_status;
        private ImageView item_icon;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.item_title = itemView.findViewById(R.id.item_title);
            this.item_location = itemView.findViewById(R.id.item_location);
            this.item_status = itemView.findViewById(R.id.item_status);
            this.item_icon = itemView.findViewById(R.id.item_icon);
        }

        void bind(final JobModel item, final int position, final JobSelectedHandler handler){
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    handler.onSelectedItem(item, position);
                }
            });
        }
    }

    public interface JobSelectedHandler {
        void onSelectedItem(JobModel item, int position);
    }
}
