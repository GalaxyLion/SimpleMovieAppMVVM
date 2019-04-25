package com.example.simplemovieappmvvm.screens.auth.login;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.simplemovieappmvvm.BR;
import com.example.simplemovieappmvvm.R;
import com.example.simplemovieappmvvm.base.App;
import com.example.simplemovieappmvvm.base.BaseActivity;
import com.example.simplemovieappmvvm.base.BaseFragment;
import com.example.simplemovieappmvvm.databinding.LoginFragmentBinding;
import com.example.simplemovieappmvvm.services.navigation.Screen;
import com.example.simplemovieappmvvm.services.navigation.ScreenType;


public class LoginFragment extends BaseFragment<LoginFragmentBinding, LoginViewModel> implements LoginNavigator {

    private LoginViewModel viewModel;
    private LoginFragmentBinding binding;
    private BaseActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (BaseActivity) getActivity();
        binding = getViewDataBinding();
        viewModel.setNavigator(this);

    }

    @Override
    public int getBindingVariable() {                   
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.login_fragment;
    }

    @Override
    public LoginViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        return viewModel;
    }


    @Override
    public void login() {
        String email = binding.login.getText().toString();
        String password = binding.password.getText().toString();
        if (viewModel.isValidData(email, password)) {
            hideKeyboard();
            viewModel.login(email, password);
        } else {
            showNotExistUser();
        }
    }

    @Override
    public void navigateToMovies() {
        activity.getNavigator().navigateTo(Screen.MOVIE, ScreenType.ACTIVITY);
    }

    @Override
    public void navigateToRegister() {
        activity.getNavigator().navigateTo(Screen.REGISTER, ScreenType.FRAGMENT);
    }

    private void showNotExistUser() {
        Toast.makeText(App.getInstance().getApplicationContext(),
                App.getInstance().getApplicationContext().getString(R.string.user) + " " +
                        App.getInstance().getApplicationContext().getString(R.string.user_not_exist),
                Toast.LENGTH_SHORT).show();
    }
}
