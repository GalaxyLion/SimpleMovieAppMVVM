package com.example.simplemovieappmvvm.screens.movies;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.simplemovieappmvvm.R;
import com.example.simplemovieappmvvm.base.App;


public class MoviePageAdapter extends FragmentStatePagerAdapter {

    public MoviePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            //case 0: return new ListMovieFragment();
            //case 1: return new GridMovieFragment();
        }
        return null;
    }
    @Override
    public int getCount() {
        return 2;
    }
    @Override    public CharSequence getPageTitle(int position) {
        switch (position){
        case 0: return App.getInstance().getApplicationContext().getString(R.string.list_blank);
        case 1: return App.getInstance().getApplicationContext().getString(R.string.grid_blank);
        default: return null;
    }
    }
}
