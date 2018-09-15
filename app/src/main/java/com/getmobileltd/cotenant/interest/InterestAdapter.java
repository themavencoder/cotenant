package com.getmobileltd.cotenant.interest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.getmobileltd.cotenant.R;

import java.util.ArrayList;
import java.util.List;

public class InterestAdapter extends RecyclerView.Adapter<InterestAdapter.MyViewHolder> {

    private Context context;
    private List<InterestModel> modelList;

    public InterestAdapter(Context context, List<InterestModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_interest,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
holder.imageView.setImageResource(modelList.get(position).getInterestImage());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;


        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.sample_image);
        }
    }
}
