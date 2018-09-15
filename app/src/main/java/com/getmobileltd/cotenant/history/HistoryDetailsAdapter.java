package com.getmobileltd.cotenant.history;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.getmobileltd.cotenant.R;

import java.util.List;

public class HistoryDetailsAdapter extends RecyclerView.Adapter<HistoryDetailsAdapter.MyViewHolder> {
    Context context;
    List<HistoryDetailsModel> modelDetailsList;

    public HistoryDetailsAdapter(Context context, List<HistoryDetailsModel> modelDetailsList) {
        this.context = context;
        this.modelDetailsList = modelDetailsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_details,parent,false);
            return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_amount.setText(modelDetailsList.get(position).getAmount());
        holder.tv_date.setText(modelDetailsList.get(position).getFullDate());
        holder.tv_halfdate.setText(modelDetailsList.get(position).getHalfDate());
    }

    @Override
    public int getItemCount() {
        return modelDetailsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_date, tv_amount,tv_halfdate;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_amount = itemView.findViewById(R.id.history_details_amount);
            tv_date = itemView.findViewById(R.id.history_details_date);
            tv_halfdate = itemView.findViewById(R.id.history_details_halfdate);
        }
    }
}
