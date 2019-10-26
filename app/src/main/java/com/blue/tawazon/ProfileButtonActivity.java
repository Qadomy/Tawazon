package com.blue.tawazon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ProfileButtonActivity extends AppCompatActivity {

    private Button closeProfileButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_button);


        closeProfileButton = findViewById(R.id.closeProfileButton);
        closeProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileButtonActivity.this, MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.activity, R.anim.bottom_down);
            }
        });

    }
}
