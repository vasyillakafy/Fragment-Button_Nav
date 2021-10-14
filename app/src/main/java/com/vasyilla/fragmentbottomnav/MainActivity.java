package com.vasyilla.fragmentbottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottomNavigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //memberi action saat button di klik
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.nav_Explore:
                        selectedFragment = new ExploreFragment();
                        break;
                    case R.id.nav_new:
                        selectedFragment = new NewFragment();
                        break;
                    case R.id.nav_notif:
                        selectedFragment = new NotifFragment();
                        break;
                    case R.id.nav_profile:
                        selectedFragment = new ProfileFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });

    }
}