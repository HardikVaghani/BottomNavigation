package com.app.fuddu.bottomnavigationwithtablayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.app.fuddu.bottomnavigationwithtablayout.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView toolbarBackArrow = findViewById(R.id.toolbar_backArrow);
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setTitle(null);//default title

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_profileFragment)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


        navController.addOnDestinationChangedListener((navController1, navDestination, bundle) -> {
            if (navController1.getCurrentDestination().getId() == R.id.navigation_home) {
                Log.e(TAG, "onDestinationChanged navigation_home");
                toolbarTitle.setText(getResources().getString(R.string.title_home));
            }
            if (navController1.getCurrentDestination().getId() == R.id.navigation_dashboard) {
                Log.e(TAG, "onDestinationChanged navigation_dashboard");
                toolbarTitle.setText(getResources().getString(R.string.title_dashboard));
            }
            if (navController1.getCurrentDestination().getId() == R.id.navigation_notifications) {
                Log.e(TAG, "onDestinationChanged navigation_notifications");
                toolbarTitle.setText(getResources().getString(R.string.title_notifications));
            }
        });

        toolbarBackArrow.setOnClickListener(view -> onBackPressed());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle back arrow clicks here
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // Close the activity when the back arrow is clicked
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        return navController.navigateUp();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            // If no fragments are in the back stack, close the app instead of navigating back
            finish();
        } else {
            // Navigate back if there are fragments in the back stack
            super.onBackPressed();
        }
    }
}
   /* // Handle the back arrow click event
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void setOnToolbarAllData() {
        // Find and set the custom Toolbar as the support ActionBar
        setSupportActionBar(toolbar);

        //         remove default elevation of actionbar
//        getSupportActionBar().setElevation(0);

        // Set the title for the Toolbar
        toolbarTitle.setText("Score");//our custom title
        Objects.requireNonNull(getSupportActionBar()).setTitle(null);//default title
        // Change title text color
        int titleTextColor = Color.WHITE;
        toolbar.setTitleTextColor(titleTextColor);

        // Add a back arrow to the Toolbar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Change back arrow color
        Objects.requireNonNull(toolbar.getNavigationIcon()).setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
    }
*/