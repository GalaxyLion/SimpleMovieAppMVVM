package com.example.simplemovieappmvvm.screens.auth.register;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.simplemovieappmvvm.BR;
import com.example.simplemovieappmvvm.R;
import com.example.simplemovieappmvvm.base.App;
import com.example.simplemovieappmvvm.base.BaseActivity;
import com.example.simplemovieappmvvm.base.BaseFragment;
import com.example.simplemovieappmvvm.base.BaseViewModel;
import com.example.simplemovieappmvvm.databinding.FragmentRegisterBinding;
import com.example.simplemovieappmvvm.services.navigation.Screen;
import com.example.simplemovieappmvvm.services.navigation.ScreenType;

public class RegisterFragment extends BaseFragment<FragmentRegisterBinding, RegisterViewModel> implements RegisterNavigator {

    private RegisterViewModel viewModel;
    private FragmentRegisterBinding binding;
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
        return R.layout.fragment_register;
    }

    @Override
    public RegisterViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);
        return viewModel;
    }

    @Override
    public void navigateToMovies() {
        activity.getNavigator().navigateTo(Screen.MOVIE, ScreenType.ACTIVITY);
    }

    @Override
    public void showExistUserError(String login) {
        Toast.makeText(App.getInstance().getApplicationContext(),
                App.getInstance().getApplicationContext().getString(R.string.user) + " " + login + " " +
                        App.getInstance().getApplicationContext().getString(R.string.user_exist),
                Toast.LENGTH_SHORT).show();


    }

    @Override
    public void showRegisterError() {
        Toast.makeText(App.getInstance().getApplicationContext(), R.string.register_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void register() {
        String email = binding.login.getText().toString();
        String password = binding.password.getText().toString();
        String confirmPassword = binding.confirmPassword.getText().toString();

        if(viewModel.isValidData(email,password,confirmPassword)){
            hideKeyboard();
            viewModel.register(email,password);
        }else{
            showRegisterError();
        }
    }
}
