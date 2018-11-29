package com.getmobileltd.cotenant.update_dashboard.adapters;

import android.content.Context;
import android.content.Intent;
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
import com.getmobileltd.cotenant.update_available_space_details.AvailableSpaceDetails;
import com.getmobileltd.cotenant.update_dashboard.models.HousesModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HousesAdapter extends RecyclerView.Adapter<HousesAdapter.MyViewHolder> {

    private Context context;
    private List<HousesModel> housesList;
    public static final String HOUSEADAPTER = "house_adapter";


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
    public void onBindViewHolder(@NonNull MyViewHolder holder,  int position) {
        final HousesModel housesModel = housesList.get(position);
        holder.stateLocation.setText(housesList.get(position).getStateLocation());
        holder.addressLOcation.setText(housesList.get(position).getAddressLocation());
        holder.bedroom.setText(housesList.get(position).getBedroom());
        holder.rent.setText(housesList.get(position).getRent());
     //   holder.image.setImageResource(housesList.get(position).getImageOfLocation());

      /*  Picasso.with(context)
                .load(R.drawable.defaultdashboard)
                .placeholder(R.drawable.ic_refresh_page)
                .into(holder.image);*/
        Glide.with(context)
                .load("http://azaliaevents.com.ng/wp-content/uploads/2018/05/IMG-20180515-WA0037.jpg")
                .apply(new RequestOptions().placeholder(new ColorDrawable(Color.GREEN)).error(R.drawable.ic_warning).centerCrop())
                .into(holder.image);
        holder.btn_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(),AvailableSpaceDetails.class);
                intent.putExtra(HOUSEADAPTER,housesModel);
                view.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return null != housesList ? housesList.size() :0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView bedroom;
        private TextView stateLocation;
        private TextView addressLOcation;
        private ImageView image;
        private TextView rent;
        private Button btn_details;
        public MyViewHolder(final View itemView) {
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
