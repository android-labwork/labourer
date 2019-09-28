package com.aitekteam.developer.labourer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aitekteam.developer.labourer.Models.PageContentModel;
import com.aitekteam.developer.labourer.R;

import java.util.ArrayList;

public class ProfilePageContentAdapter extends RecyclerView.Adapter<ProfilePageContentAdapter.ViewHolder> {
    private ArrayList<PageContentModel> items;
    private PageContentSelectedHandler handler;
    private Context context;

    public ProfilePageContentAdapter(ArrayList<PageContentModel> items, PageContentSelectedHandler handler) {
        this.items = items;
        this.handler = handler;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_item_list_page_content,
                parent, false);
        this.context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PageContentModel item = this.items.get(position);
        holder.bind(item, position, this.handler);
        holder.content_label.setText(item.getLabel());
        holder.content_description.setText(this.convertDescription(item.getValue(), item.getSatuan()));
        holder.content_icon.setImageResource(item.getIcon());
    }

    private String convertDescription(int value, String satuan) {
        return "" + value + " " + satuan;
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView content_label, content_description;
        ImageView content_icon;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.content_label = this.itemView.findViewById(R.id.content_label);
            this.content_description = this.itemView.findViewById(R.id.content_description);
            this.content_icon = this.itemView.findViewById(R.id.content_icon);
        }

        void bind(final PageContentModel item, final int position, final PageContentSelectedHandler handler) {
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    handler.onSelectedItem(item, position);
                }
            });
        }
    }

    public interface PageContentSelectedHandler {
        void onSelectedItem(PageContentModel item, int position);
    }
}
