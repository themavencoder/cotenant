package com.getmobileltd.cotenant.update_dashboard.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.update_available_space_details.AvailableSpaceDetails;
import com.getmobileltd.cotenant.update_dashboard.models.DashboardInterestModel;
import com.getmobileltd.cotenant.update_dashboard.models.HousesModel;

import java.util.List;

public class DashboardInterestAdapter extends RecyclerView.Adapter<DashboardInterestAdapter.MyViewHolder> {
    private Context context;
    private List<DashboardInterestModel> interestList;
    public DashboardInterestAdapter(Context context, List<DashboardInterestModel> interestList) {
        this.context = context;
        this.interestList = interestList;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dashboard_interest_main,parent,false);

        return new DashboardInterestAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.stateLocation.setText(interestList.get(position).getStateLocation());
        holder.addressLOcation.setText(interestList.get(position).getAddressLocation());
        holder.bedroom.setText(interestList.get(position).getBedroom());
        holder.rent.setText(interestList.get(position).getRent());
        holder.image.setImageResource(interestList.get(position).getImageOfLocation());

    }

    @Override
    public int getItemCount() {
        return (null != interestList ? interestList.size() : 0);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView bedroom;
        private TextView stateLocation;
        private TextView addressLOcation;
        private ImageView image;
        private TextView rent;
        private Button btn_details;
        public MyViewHolder(View itemView) {
            super(itemView);
            bedroom = itemView.findViewById(R.id.bedroomNumber);
            stateLocation = itemView.findViewById(R.id.stateLocation);
            addressLOcation = itemView.findViewById(R.id.addressLocation);
            image = itemView.findViewById(R.id.apartmentImage);
            rent = itemView.findViewById(R.id.rent);
            btn_details = itemView.findViewById(R.id.details_button);
            btn_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(),AvailableSpaceDetails.class);
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
