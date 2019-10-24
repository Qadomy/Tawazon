package com.blue.tawazon;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.blue.tawazon.Adapter.FragmentPagesAdapter;
import com.blue.tawazon.Adapter.GifImagesAdapter;
import com.blue.tawazon.Fragments.FragmentBody;
import com.blue.tawazon.Fragments.FragmentHome;
import com.blue.tawazon.Fragments.FragmentKids;
import com.blue.tawazon.Fragments.FragmentMeditation;
import com.blue.tawazon.Fragments.FragmentSoul;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static maes.tech.intentanim.CustomIntent.customType;

public class MainActivity extends AppCompatActivity {

    private FragmentPagesAdapter sectionPagesAdapter;
    private ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;
    private FrameLayout frameLayout;
    private Button profileButton;

//    // fragments
    private final Fragment homeFragment = new FragmentHome();
    private final Fragment soulFragment = new FragmentSoul();
    private final Fragment meditationFragment = new FragmentMeditation();
    private final Fragment bodyFragment = new FragmentBody();
    private final Fragment kidsFragment = new FragmentKids();

    private final FragmentManager fm = getSupportFragmentManager();
    private Fragment active = homeFragment;



    private GifImagesAdapter adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView = findViewById(R.id.bottomnavigation);

        // init profile button
        profileButton = findViewById(R.id.profileButton);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ProfileButton.class);
                startActivity(i);
                customType(MainActivity.this,"bottom-to-up");


            }
        });

//        mViewPager = findViewById(R.id.homeViewPager);
        //setupViewPager(mViewPager);

        //frameLayout = findViewById(R.id.frameLayout);

        //setFragment(new FragmentHome());
        addListener(); // add bottom navigator view buttons


        viewPager = findViewById(R.id.homeViewPager);
        adapter = new GifImagesAdapter(this);

        // set the images in view pager
        viewPager.setAdapter(adapter);

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

                switch (menuItem.getItemId()){
                    case R.id.home_icon:
//                        mViewPager.setCurrentItem(0);
//                        setFragment(fragmentHome);
//                        selectedFragment = new FragmentHome();
                        menuItem.setIcon(R.drawable.ic_bird);

                        fm.beginTransaction().hide(active).show(homeFragment).commit();
                        active = homeFragment;
                        return true;

                    case R.id.body_icon:
//                        mViewPager.setCurrentItem(1);
//                        setFragment(fragmentBody);
//                        selectedFragment = new FragmentBody();
                        fm.beginTransaction().hide(active).show(bodyFragment).commit();
                        active = bodyFragment;
                        return true;

                    case R.id.meditation_icon:
//                        mViewPager.setCurrentItem(2);
//                        setFragment(fragmentMeditation);
//                        selectedFragment = new FragmentMeditation();
                        fm.beginTransaction().hide(active).show(meditationFragment).commit();
                        active = meditationFragment;
                        return true;

                    case R.id.soul_icon:
//                        mViewPager.setCurrentItem(3);
//                        setFragment(fragmentSoul);
//                        selectedFragment = new FragmentSoul();
                        fm.beginTransaction().hide(active).show(soulFragment).commit();
                        active = soulFragment;
                        return true;

                    case R.id.kids_icon:
//                        mViewPager.setCurrentItem(4);
//                        setFragment(fragmentKids);
//                        selectedFragment = new FragmentKids();
                        fm.beginTransaction().hide(active).show(kidsFragment).commit();
                        active = kidsFragment;
                        return true;
                }
//                return setFragment(selectedFragment);
                return false;
            }
        });
    }// end add listener

    private boolean setFragment(Fragment fragment) {
        if (fragment != null){

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

}
