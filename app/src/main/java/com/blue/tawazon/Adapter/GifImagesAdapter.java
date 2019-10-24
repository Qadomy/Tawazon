package com.blue.tawazon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.blue.tawazon.R;

import pl.droidsonroids.gif.GifImageView;

public class GifImagesAdapter extends PagerAdapter {


    private int[] images_resource = {
            R.drawable.gif2,
            R.drawable.gif1,
            R.drawable.gif3
    };

    private Context context;
    private LayoutInflater layoutInflater;

    public GifImagesAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images_resource.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.swip_layout, container, false);

        GifImageView gifImageView = (GifImageView) view.findViewById(R.id.gifImageView);
        gifImageView.setImageResource(images_resource[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout) object);
    }
}
