package com.example.simplemovieappmvvm.screens.auth;

import android.arch.lifecycle.ViewModelProviders;
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

public class AuthActivity extends BaseActivity<ActivityAuthBinding, AuthViewModel> implements AuthNavigator {

    private AuthViewModel viewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_auth;
    }

    @Override
    public AuthViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this).get(AuthViewModel.class);
        return viewModel;
    }

    @Override
    public void navigateToLogin() {
        getNavigator().navigateTo(Screen.LOGIN, ScreenType.FRAGMENT);
    }

    @Override
    public void navigateToMovies() {
        getNavigator().navigateTo(Screen.MOVIE, ScreenType.ACTIVITY);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        viewModel.setNavigator(this);
        viewModel.decideNavigateTo();

    }
}
