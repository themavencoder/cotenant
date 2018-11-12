package com.getmobileltd.cotenant.update_available_space.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.update_available_space.model.AvailableSpaceModel;
import com.getmobileltd.cotenant.update_available_space_details.AvailableSpaceDetails;

import java.util.ArrayList;
import java.util.List;

public class AvailableSpaceAdapter extends RecyclerView.Adapter<AvailableSpaceAdapter.MyViewModel> {
    private List<AvailableSpaceModel> spaceList;
    private Context context;

    public AvailableSpaceAdapter(List<AvailableSpaceModel> spaceList, Context context) {
        this.context = context;
        this.spaceList = spaceList;
    }


    @NonNull
    @Override
    public MyViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_available_space,parent,false);
        return new MyViewModel(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewModel holder, int position) {
        holder.stateLocation.setText(spaceList.get(position).getStateLocation());
        holder.addressLOcation.setText(spaceList.get(position).getAddressLocation());
        holder.bedroom.setText(spaceList.get(position).getBedroom());
        holder.rent.setText(spaceList.get(position).getRent());
        holder.image.setImageResource(spaceList.get(position).getImageOfLocation());


    }

    @Override
    public int getItemCount() {
        return spaceList.size();
    }

    public static class MyViewModel extends RecyclerView.ViewHolder {
        private TextView bedroom;
        private TextView stateLocation;
        private TextView addressLOcation;
        private ImageView image;
        private TextView rent;
        private Button btn_details;

        public MyViewModel(View itemView) {
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

    public void updateList(List<AvailableSpaceModel> model) {
        spaceList = new ArrayList<>();
        spaceList.addAll(model);
        notifyDataSetChanged();

    }
}
