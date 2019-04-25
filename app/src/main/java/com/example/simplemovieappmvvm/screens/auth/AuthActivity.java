package com.example.simplemovieappmvvm.screens.auth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.simplemovieappmvvm.BR;
import com.example.simplemovieappmvvm.R;
import com.example.simplemovieappmvvm.base.BaseActivity;
import com.example.simplemovieappmvvm.base.BaseViewModel;
import com.example.simplemovieappmvvm.databinding.ActivityAuthBinding;
import com.example.simplemovieappmvvm.services.navigation.Screen;
import com.example.simplemovieappmvvm.services.navigation.ScreenType;
import com.example.simplemovieappmvvm.utils.PrefsKeys;
import com.pixplicity.easyprefs.library.Prefs;

public class AuthActivity extends BaseActivity {

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);



        Prefs.putLong(PrefsKeys.TIME, System.currentTimeMillis());
        if (Prefs.getString(PrefsKeys.EMAIL, "") != null && !Prefs.getString(PrefsKeys.EMAIL, "").equals("EMAIL")
                && !Prefs.getString(PrefsKeys.EMAIL, "").equals("")) {
            //getNavigator().navigateTo(Screen.MOVIE, ScreenType.ACTIVITY);
        } else {
            //getNavigator().navigateTo(Screen.LOGIN, ScreenType.FRAGMENT);
        }
    }
}
