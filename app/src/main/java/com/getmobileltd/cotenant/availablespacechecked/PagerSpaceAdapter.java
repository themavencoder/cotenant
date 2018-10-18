package com.getmobileltd.cotenant.availablespacechecked;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.getmobileltd.cotenant.R;

import java.util.List;

public class PagerSpaceAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<DataSource> dataSourceList;


    public PagerSpaceAdapter(Context context, List<DataSource> dataSourceList) {
        this.dataSourceList = dataSourceList;
        this.context = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        View view = (View) object;
        container.removeView(view);
    }
}
