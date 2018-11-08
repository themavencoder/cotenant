package com.getmobileltd.cotenant.update_dashboard.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.update_dashboard.models.HousesModel;

import java.util.List;

public class HousesAdapter extends RecyclerView.Adapter<HousesAdapter.MyViewHolder> {

    private Context context;
    private List<HousesModel> housesList;

    public HousesAdapter(Context context, List<HousesModel> housesList) {
        this.context = context;
        this.housesList = housesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dashboard_houses_sub,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.stateLocation.setText(housesList.get(position).getStateLocation());
        holder.addressLOcation.setText(housesList.get(position).getAddressLocation());
        holder.bedroom.setText(housesList.get(position).getBedroom());
        holder.rent.setText(housesList.get(position).getRent());
        holder.image.setImageResource(housesList.get(position).getImageOfLocation());

    }

    @Override
    public int getItemCount() {
        return housesList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView bedroom;
        private TextView stateLocation;
        private TextView addressLOcation;
        private ImageView image;
        private TextView rent;

        public MyViewHolder(View itemView) {
            super(itemView);
            bedroom = itemView.findViewById(R.id.bedroomNumber);
            stateLocation = itemView.findViewById(R.id.stateLocation);
            addressLOcation = itemView.findViewById(R.id.addressLocation);
            image = itemView.findViewById(R.id.apartmentImage);
            rent = itemView.findViewById(R.id.rent);
        }
    }
}
