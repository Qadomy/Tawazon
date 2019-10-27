package com.blue.tawazon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


public class ProfileButtonActivity extends Activity {

    private Button closeProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_profile_button);
        this.getWindow().setBackgroundDrawableResource(android.R.color.black); // to set the boundaries black color
        this.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT); // to display the activity as full screen dialog


        closeProfileButton = findViewById(R.id.closeProfileButton);
        closeProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(ProfileButtonActivity.this, MainActivity.class);
//                startActivity(i);
                overridePendingTransition(R.anim.activity, R.anim.bottom_down);
                finish();
            }
        });

    }
}
