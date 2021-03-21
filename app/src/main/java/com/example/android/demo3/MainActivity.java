package com.example.android.demo3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.widget.VideoView;

import com.example.android.demo3.Fragments.HomeFragment;
import com.example.android.demo3.Fragments.PodcastFragment;
import com.example.android.demo3.Fragments.ProfileFragment;
import com.example.android.demo3.Fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_VIDEO_CAPTURE = 1;
    private BottomNavigationView bottomNavigationView;
    private Fragment selectorFragment;
    VideoView videoView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        selectorFragment = new HomeFragment();
                        break;

                    case R.id.nav_video:
                        selectorFragment = null;
                        Intent intent = new Intent(MainActivity.this,PostActivity.class);
                        startActivity(intent);

                        break;

                    case R.id.nav_live:


                        Intent live_intent = new Intent(MainActivity.this,GoliveActivity.class);
                        startActivity(live_intent);
                        break;

                    case R.id.nav_audio:
                        selectorFragment = new PodcastFragment();
                        break;

                    case R.id.nav_person:
                        selectorFragment = new ProfileFragment();
                        break;
                }

                if(selectorFragment != null)
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectorFragment).commit();
                return true;

            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();

    }

}