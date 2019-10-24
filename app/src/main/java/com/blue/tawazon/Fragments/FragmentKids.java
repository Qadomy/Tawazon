package com.blue.tawazon.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blue.tawazon.R;

public class FragmentKids extends Fragment {


    public static FragmentKids newInstance(){
        FragmentKids fragmentKids = new FragmentKids();
        return fragmentKids;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_kids, container, false);
        return view;
    }


}
