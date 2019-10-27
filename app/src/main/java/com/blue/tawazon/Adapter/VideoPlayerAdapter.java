package com.blue.tawazon.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.blue.tawazon.R;

public class VideoPlayerAdapter extends PagerAdapter {

    private VideoView video_player_view;
    private Uri uri;

    private int[] videoResource = {
            R.raw.video1,
            R.raw.video2,
            R.raw.video3
    };

    private Context context;
    private LayoutInflater layoutInflater;


    public VideoPlayerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return videoResource.length;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.layout_swip_video, container, false);

        uri = Uri.parse("android.resource://" + context.getPackageName() + "/" + videoResource[position]);


        video_player_view = (VideoView) view.findViewById(R.id.videoView);
        video_player_view.setVideoURI(uri);


        video_player_view.requestFocus();
        video_player_view.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {

                mediaPlayer.setLooping(true);

                // here for display the video in full screen
                DisplayMetrics metrics = new DisplayMetrics();
                ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
                android.widget.RelativeLayout.LayoutParams params = (android.widget.RelativeLayout.LayoutParams) video_player_view.getLayoutParams();
                params.width = metrics.widthPixels;
                params.height = metrics.heightPixels;
                params.leftMargin = 0;
                video_player_view.setLayoutParams(params);


                // start video
                video_player_view.start();
            }
        });

        //todo
        video_player_view.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                video_player_view.seekTo(1);
                video_player_view.setBackgroundColor(Color.TRANSPARENT);
            }
        });

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (RelativeLayout) object);
    }
}





