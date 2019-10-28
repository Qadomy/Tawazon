package com.blue.tawazon;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.blue.tawazon.Adapter.FragmentPagesAdapter;
import com.blue.tawazon.Adapter.VideoPlayerAdapter;
import com.blue.tawazon.Fragments.FragmentBody;
import com.blue.tawazon.Fragments.FragmentHome;
import com.blue.tawazon.Fragments.FragmentKids;
import com.blue.tawazon.Fragments.FragmentMeditation;
import com.blue.tawazon.Fragments.FragmentSoul;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    private FragmentPagesAdapter sectionPagesAdapter;
    private BottomNavigationView mBottomNavigationView;
    private TabLayout tabLayout;

    // ***

    private ViewPager viewPager;

    private VideoPlayerAdapter playerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView = findViewById(R.id.bottomnavigation);

        addListener(); // add bottom navigator view buttons


        playerAdapter = new VideoPlayerAdapter(this);

        viewPager = findViewById(R.id.homeViewPager);
        viewPager.setAdapter(playerAdapter);


        tabLayout = findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager, true);

        // here to disable to click on indicators
        tabLayout.clearOnTabSelectedListeners();
        for (View v : tabLayout.getTouchables()) {
            v.setEnabled(false);
        }


    }// end of onCreate



    @Override
    protected void onStart() {
        super.onStart();
        viewPager.setAdapter(playerAdapter);
    }

    // when click on menu button to open dialog
    public void openMenuDialog(View view) {

        LayoutInflater li = LayoutInflater.from(MainActivity.this);
        View promptsView = li.inflate(R.layout.activity_sounds_menu, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(promptsView);

        // create alert dialog and show it
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void openF(View view) {

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }

    private void addListener() {

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //Fragment selectedFragment = null;

                switch (menuItem.getItemId()) {
                    case R.id.home_icon:
                        menuItem.setIcon(R.drawable.bottom_navigation_home_click);
                        return true;

                    case R.id.body_icon:
                        menuItem.setIcon(R.drawable.bottom_navigation_body_click);
                        return true;

                    case R.id.meditation_icon:
                        menuItem.setIcon(R.drawable.bottom_navigation_meditation_click);
                        return true;

                    case R.id.soul_icon:
                        menuItem.setIcon(R.drawable.bottom_navigation_soul_click);
                        return true;

                    case R.id.kids_icon:
                        menuItem.setIcon(R.drawable.bottom_navigation_kids_click);
                        return true;
                }
                return false;
            }
        });
    }// end add listener

    private boolean setFragment(Fragment fragment) {
        if (fragment != null) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();

            return true;
        }
        return false;
    }

    // method for add the all fragments in the view pager
    private void setupViewPager(ViewPager viewPager) {

        sectionPagesAdapter = new FragmentPagesAdapter(getSupportFragmentManager());

        // here we add the fragments
        sectionPagesAdapter.addFragment(FragmentHome.newInstance());
        sectionPagesAdapter.addFragment(FragmentBody.newInstance());
        sectionPagesAdapter.addFragment(FragmentSoul.newInstance());
        sectionPagesAdapter.addFragment(FragmentKids.newInstance());
        sectionPagesAdapter.addFragment(FragmentMeditation.newInstance());

        viewPager.setAdapter(sectionPagesAdapter);
    }


    // when click on profile menu button
    public void openProfileMenu(View view) {
//        mBottomNavigationView.setVisibility(View.GONE);
        Intent i = new Intent(MainActivity.this, ProfileButtonActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.bottom_up, R.anim.activity);

    }

    // when click on sounds menu button
    public void openSoundsMenu(View view) {
        Intent i = new Intent(MainActivity.this, SoundsMenuActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

    }
}
