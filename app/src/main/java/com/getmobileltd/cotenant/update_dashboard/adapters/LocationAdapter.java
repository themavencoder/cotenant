package com.getmobileltd.cotenant.update_dashboard.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.update_dashboard.models.LocationModel;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.MyViewHolder> {

    private Context context;

    private List<LocationModel> locationList;


    public LocationAdapter(Context context, List<LocationModel> locationList) {
        this.context = context;
        this.locationList = locationList;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dashboard_location_main,parent,false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.locationName.setText(locationList.get(position).getLocationOfPlace());
        HousesAdapter housesAdapter = new HousesAdapter(context,locationList.get(position).getModelList());
        holder.recycler_view_list_houses.setHasFixedSize(true);
        holder.recycler_view_list_houses.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        holder.recycler_view_list_houses.setAdapter(housesAdapter);

    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }


    public static class MyViewHolder extends  RecyclerView.ViewHolder {
        private TextView locationName;
        private RecyclerView recycler_view_list_houses;

        public MyViewHolder(View itemView) {
            super(itemView);

            locationName = itemView.findViewById(R.id.locationName);
            recycler_view_list_houses = itemView.findViewById(R.id.recycler_view_list_houses);
        }
    }

}
