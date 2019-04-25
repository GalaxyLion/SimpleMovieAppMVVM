package com.example.simplemovieappmvvm.screens.movies;

import android.support.v4.widget.DrawerLayout;

import com.example.simplemovieappmvvm.base.BaseViewModel;
import com.example.simplemovieappmvvm.utils.PrefsKeys;
import com.pixplicity.easyprefs.library.Prefs;

public class MovieViewModel extends BaseViewModel<MovieNavigator> {



    public void onProfileClick(){
        getNavigator().navigateToProfile();
    }

    public void onLogoutClick(){
        Prefs.remove(PrefsKeys.EMAIL);
        getNavigator().navigateToAuth();
    }




}
