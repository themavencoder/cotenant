package com.getmobileltd.cotenant.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.accountkit.AccountKit;
import com.getmobileltd.cotenant.MainActivity;
import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.profile.ProfileActivity;

import java.util.ArrayList;
import java.util.List;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.MyViewHolder> {
    private Context context;
    private List<SettingsModel> modelList;

    public SettingsAdapter(Context context, List<SettingsModel> modelList) {
        this.context = context;
     this.modelList = modelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_settings,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final String queryString = modelList.get(position).getValue();

        holder.textView.setText(modelList.get(position).getValue());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (queryString) {
                    case "Profile":
                        view.getContext().startActivity(new Intent(view.getContext(),ProfileActivity.class));
                        break;
                    case "Log out":
                        AccountKit.logOut();
                        view.getContext().startActivity(new Intent(view.getContext(),MainActivity.class));
                        ((Activity)context).finish();


                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
    public MyViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textViewSettings);


    }

}
}
