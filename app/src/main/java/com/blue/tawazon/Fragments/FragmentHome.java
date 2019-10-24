package com.blue.tawazon.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.blue.tawazon.Adapter.GifImagesAdapter;
import com.blue.tawazon.Main2Activity;
import com.blue.tawazon.R;

public class FragmentHome extends Fragment {

    private GifImagesAdapter adapter;
    private ViewPager viewPager;

    public FragmentHome() {
    }

    public static FragmentHome newInstance(){
        FragmentHome fragmentHome = new FragmentHome();
        return fragmentHome;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_home, container, false);

        // init View Pager
        viewPager = view.findViewById(R.id.homeViewPager);
        adapter = new GifImagesAdapter(getActivity());

        // set the images in view pager
        viewPager.setAdapter(adapter);

        return view;
    }


    public void openF(View view) {

        Intent intent = new Intent(getActivity(), Main2Activity.class);
        startActivity(intent);
    }

}
