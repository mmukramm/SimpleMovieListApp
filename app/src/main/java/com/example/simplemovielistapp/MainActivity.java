package com.example.simplemovielistapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.simplemovielistapp.api.ApiConfig;
import com.example.simplemovielistapp.api.MovieDataResponse;
import com.example.simplemovielistapp.api.MovieResponse;
import com.example.simplemovielistapp.api.TvDataResponse;
import com.example.simplemovielistapp.api.TvResponse;
import com.example.simplemovielistapp.fragment.FavouriteFragment;
import com.example.simplemovielistapp.fragment.MovieFragment;
import com.example.simplemovielistapp.fragment.TvFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static BottomNavigationView bottom_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        displayMovieFragment(fragmentManager);

        bottom_nav = findViewById(R.id.bottom_nav);
        bottom_nav.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.movieMenu)
            {
                displayMovieFragment(fragmentManager);
            }
            else if (item.getItemId() == R.id.tvShowMenu)
            {
                displayTvFragment(fragmentManager);
            }
            else if (item.getItemId() == R.id.favouriteMenu)
            {
                displayFavouriteFragment(fragmentManager);
            }
            return true;
        });

    }

    private void displayMovieFragment(FragmentManager fm) {
        MovieFragment movieFragment = new MovieFragment();
        Fragment fragment = fm.findFragmentByTag(MovieFragment.class.getSimpleName());
        if (!(fragment instanceof MovieFragment)) {
            fm.beginTransaction().replace(R.id.fragment_container, movieFragment, MovieFragment.class.getSimpleName()).commit();
        }
    }

    private void displayTvFragment(FragmentManager fm) {
        TvFragment tvFragment = new TvFragment();
        Fragment fragment = fm.findFragmentByTag(TvFragment.class.getSimpleName());
        if (!(fragment instanceof TvFragment)) {
            fm.beginTransaction().replace(R.id.fragment_container, tvFragment, TvFragment.class.getSimpleName()).commit();
        }
    }

    private void displayFavouriteFragment(FragmentManager fm) {
        FavouriteFragment favouriteFragment = new FavouriteFragment();
        Fragment fragment = fm.findFragmentByTag(FavouriteFragment.class.getSimpleName());
        if (!(fragment instanceof FavouriteFragment)) {
            fm.beginTransaction().replace(R.id.fragment_container, favouriteFragment, FavouriteFragment.class.getSimpleName()).commit();
        }
    }
}