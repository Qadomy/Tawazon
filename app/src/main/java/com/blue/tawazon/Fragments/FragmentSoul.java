package com.blue.tawazon.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blue.tawazon.R;

public class FragmentSoul extends Fragment {


    public static FragmentSoul newInstance(){
        FragmentSoul fragmentSoul = new FragmentSoul();
        return fragmentSoul;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_soul, container, false);
        return view;
    }

}
