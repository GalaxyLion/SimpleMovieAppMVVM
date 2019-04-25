package com.example.simplemovieappmvvm.screens.auth;

import com.example.simplemovieappmvvm.base.BaseViewModel;
import com.example.simplemovieappmvvm.utils.PrefsKeys;
import com.pixplicity.easyprefs.library.Prefs;

public class AuthViewModel extends BaseViewModel<AuthNavigator> {


    public void decideNavigateTo() {
        Prefs.putLong(PrefsKeys.TIME, System.currentTimeMillis());
        if (Prefs.getString(PrefsKeys.EMAIL, "") != null && !Prefs.getString(PrefsKeys.EMAIL, "").equals("EMAIL")
                && !Prefs.getString(PrefsKeys.EMAIL, "").equals("")) {
            getNavigator().navigateToMovies();
        } else {
            getNavigator().navigateToLogin();
        }
    }

}
