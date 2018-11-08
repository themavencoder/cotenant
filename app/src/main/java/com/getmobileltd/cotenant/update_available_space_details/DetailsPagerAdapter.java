package com.getmobileltd.cotenant.update_available_space_details;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.aboutyoumvp.Data;

import java.util.List;

public class DetailsPagerAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<DataSource> dataSourceList;


    public DetailsPagerAdapter(Context context, List<DataSource> dataSourceList) {
        this.context = context;
        this.dataSourceList = dataSourceList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return dataSourceList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.item_pager_space,container,false);
        ImageView imageView = view.findViewById(R.id.imageViewTop);
        imageView.setImageResource(dataSourceList.get(position).getImage());
        container.addView(imageView);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view  = (View) object;
        container.removeView(view);
    }
}
