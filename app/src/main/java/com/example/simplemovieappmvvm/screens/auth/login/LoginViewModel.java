package com.example.simplemovieappmvvm.screens.auth.login;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.simplemovieappmvvm.R;
import com.example.simplemovieappmvvm.base.App;
import com.example.simplemovieappmvvm.base.BaseViewModel;
import com.example.simplemovieappmvvm.data.repositories.LoginLocalRepositoryRealmImpl;
import com.example.simplemovieappmvvm.data.repositories.LoginRepository;

import com.example.simplemovieappmvvm.services.login_db.entities.LoginEntityRealm;

import com.example.simplemovieappmvvm.utils.LoginUtils;
import com.example.simplemovieappmvvm.utils.PrefsKeys;
import com.pixplicity.easyprefs.library.Prefs;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    private LoginRepository loginLocalRepositoryRealm;


    public LoginViewModel() {

        loginLocalRepositoryRealm = new LoginLocalRepositoryRealmImpl();
    }


    public boolean isValidData(String email, String password) {
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        if (!LoginUtils.validateLogin(email)) {
            return false;
        }
        if (!LoginUtils.validatePassword(password)) {
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            return false;
        }
        return true;
    }

    public void login(String email, String password) {
        LoginEntityRealm loginEntityRealm = loginLocalRepositoryRealm.getExistUser(email);
        if (loginEntityRealm != null) {
            Prefs.putString(PrefsKeys.EMAIL, email);
            getNavigator().navigateToMovies();
        }
    }

    public void onLoginClick() {
       getNavigator().login();
    }

    public void onRegisterClick() {
        getNavigator().navigateToRegister();
    }




  /*  public void setNavigator(Navigator navigator){
        this.navigator = navigator;
    }*/
}
