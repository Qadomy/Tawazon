package com.blue.tawazon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blue.tawazon.Adapter.SoundMenuAdapter;
import com.blue.tawazon.Classes.SoundItem;

import java.util.ArrayList;

public class SoundsMenuActivity extends Activity {

    // here for display the sound items when open sound menu
    private RecyclerView displaySoundItemsRecyclerView;
    private SoundMenuAdapter soundMenuAdapter;
    private ArrayList<SoundItem> soundItems = new ArrayList<>();

    // ***
    private Button musicON, musicOFF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // here to hide the title of app name over activity when display at dialog
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sounds_menu);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        this.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT); // to display the activity as full screen dialog

        musicON = findViewById(R.id.musicOn);
        musicOFF = findViewById(R.id.musicOff);

        musicON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicON.setVisibility(View.GONE);
                musicOFF.setVisibility(View.VISIBLE);
            }
        });

        musicOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicOFF.setVisibility(View.GONE);
                musicON.setVisibility(View.VISIBLE);
            }
        });

        // init RecyclerView
        displaySoundItemsRecyclerView = findViewById(R.id.recyclerViewSoundItems);

        showSoundItemsRecycleView();

    }// end of onCreate

    // display the recycler view
    private void showSoundItemsRecycleView() {

        soundItems.add(new SoundItem(R.drawable.ic_water_sound, "هدوء الماء المنسل"));
        soundItems.add(new SoundItem(R.drawable.ic_burn, "دفئ الحطب المحترق"));
        soundItems.add(new SoundItem(R.drawable.ic_rain, "احتضان الماء المنهمر"));
        soundItems.add(new SoundItem(R.drawable.ic_pip_birds, "فرحة زقزقة العصافير"));
        soundItems.add(new SoundItem(R.drawable.ic_nature, "تكلم جمال الطبيعة"));


        // here how we want to display the list of sounds
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        displaySoundItemsRecyclerView.setLayoutManager(linearLayoutManager);
        displaySoundItemsRecyclerView.setHasFixedSize(true);

        //To show them in descending order
        soundMenuAdapter = new SoundMenuAdapter(soundItems, this);
        displaySoundItemsRecyclerView.setAdapter(soundMenuAdapter);
        displaySoundItemsRecyclerView.setVisibility(View.VISIBLE);

    }


    // when click on menu button to disappear it
    public void closeSoundMenu(View view) {
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        finish();
    }
}
