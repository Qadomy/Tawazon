package com.blue.tawazon;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blue.tawazon.Adapter.SoundMenuAdapter;
import com.blue.tawazon.Classes.SoundItem;

import java.util.ArrayList;

public class SoundsMenuActivity extends AppCompatActivity {

    // here for display the sound items when open sound menu
    private RecyclerView displaySoundItemsRecyclerView;
    private SoundMenuAdapter soundMenuAdapter;
    private ArrayList<SoundItem> soundItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds_menu);

        // init RecyclerView
        displaySoundItemsRecyclerView = findViewById(R.id.recyclerViewSoundItems);

        showSoundItemsRecycleView();

    }// end of onCreate

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


}