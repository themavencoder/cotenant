package com.getmobileltd.cotenant.interest.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.interest.model.InterestModel;

import java.util.List;

public class InterestAdapter extends RecyclerView.Adapter<InterestAdapter.ViewHolder> {
    private List<InterestModel> modelList;
    private Context context;

    public InterestAdapter(Context context, List<InterestModel> modelList) {
        this.context = context;
        this.modelList = modelList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_interest, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.stateLocation.setText(modelList.get(position).getStateLocation());
        holder.addressLOcation.setText(modelList.get(position).getAddressLocation());
        holder.bedroom.setText(modelList.get(position).getBedroom());
        holder.rent.setText(modelList.get(position).getRent());
        Glide.with(context)
                .load("http://azaliaevents.com.ng/wp-content/uploads/2018/05/IMG-20180515-WA0037.jpg")
                .apply(new RequestOptions().placeholder(new ColorDrawable(Color.GREEN)).error(R.drawable.ic_warning).centerCrop())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return null != modelList ? modelList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView bedroom;
        private TextView stateLocation;
        private TextView addressLOcation;
        private ImageView image;
        private TextView rent;
        private Button btn_details;

        public ViewHolder(View itemView) {
            super(itemView);

            bedroom = itemView.findViewById(R.id.bedroomNumber);
            stateLocation = itemView.findViewById(R.id.stateLocation);
            addressLOcation = itemView.findViewById(R.id.addressLocation);
            image = itemView.findViewById(R.id.apartmentImage);
            rent = itemView.findViewById(R.id.rent);
            btn_details = itemView.findViewById(R.id.details_button);
        }
    }
}