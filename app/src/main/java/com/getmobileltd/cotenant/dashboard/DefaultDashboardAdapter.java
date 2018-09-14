package com.getmobileltd.cotenant.dashboard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.getmobileltd.cotenant.R;

import java.util.List;

public class DefaultDashboardAdapter extends RecyclerView.Adapter<DefaultDashboardAdapter.MyViewHolder> {
    Context context;
    List<DefaultDashboardModel> defaultDashboardModelList;

    public DefaultDashboardAdapter(Context context, List<DefaultDashboardModel> defaultDashboardModelList) {
        this.context = context;
        this.defaultDashboardModelList = defaultDashboardModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_default_dashboard,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.dashboardImage.setImageResource(defaultDashboardModelList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return defaultDashboardModelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView dashboardImage;

            public MyViewHolder(View itemView) {
                super(itemView);
                dashboardImage = itemView.findViewById(R.id.img_default_dashboard_item);
            }
        }
}
