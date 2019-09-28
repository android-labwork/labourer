package com.aitekteam.developer.labourer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aitekteam.developer.labourer.Models.NotificationModel;
import com.aitekteam.developer.labourer.R;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private ArrayList<NotificationModel> items;
    private NotificationSelectedHandler handler;
    private Context context;

    public NotificationAdapter(ArrayList<NotificationModel> items, NotificationSelectedHandler handler) {
        this.items = items;
        this.handler = handler;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_item_notification,
                parent, false);
        this.context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotificationModel item = this.items.get(position);
        holder.bind(item, position, this.handler);

        holder.item_name.setText(item.getSender_name());
        holder.item_message.setText(item.getMessage());
        holder.item_icon.setImageResource(R.drawable.user_50);
        if (item.getStatus() == 1) {
            holder.itemView.setBackgroundColor(this.context.getResources().getColor(R.color.colorTransparent));
            holder.itemView.setAlpha(.5f);
        }
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private View itemView;
        private TextView item_name, item_message;
        private ImageView item_icon;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.item_name = itemView.findViewById(R.id.item_name);
            this.item_message = itemView.findViewById(R.id.item_message);
            this.item_icon = itemView.findViewById(R.id.item_icon);
        }

        void bind(final NotificationModel item, final int position, final NotificationSelectedHandler handler){
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    handler.onSelectedItem(item, position);
                }
            });
        }
    }

    public interface NotificationSelectedHandler {
        void onSelectedItem(NotificationModel item, int position);
    }
}
