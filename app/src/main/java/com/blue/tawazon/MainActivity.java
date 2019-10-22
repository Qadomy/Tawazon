package com.blue.tawazon;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.blue.tawazon.Adapter.CustomSwipAdapter;

public class MainActivity extends AppCompatActivity {

    private CustomSwipAdapter adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init View Pager
        viewPager = findViewById(R.id.viewPager);
        adapter = new CustomSwipAdapter(this);

        // set the images in view pager
        viewPager.setAdapter(adapter);
    }
}
