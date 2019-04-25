package com.example.simplemovieappmvvm.screens.auth.register;

import android.text.TextUtils;

import com.example.simplemovieappmvvm.base.BaseViewModel;
import com.example.simplemovieappmvvm.data.repositories.LoginLocalRepositoryRealmImpl;
import com.example.simplemovieappmvvm.services.login_db.entities.LoginEntityRealm;
import com.example.simplemovieappmvvm.utils.LoginUtils;
import com.example.simplemovieappmvvm.utils.PrefsKeys;
import com.pixplicity.easyprefs.library.Prefs;

import java.util.UUID;

public class RegisterViewModel extends BaseViewModel<RegisterNavigator> {

    private LoginLocalRepositoryRealmImpl loginLocalRepositoryRealm;
    private LoginEntityRealm login;

    public RegisterViewModel() {
        loginLocalRepositoryRealm = new LoginLocalRepositoryRealmImpl();
        login = new LoginEntityRealm();
    }

    public boolean isValidData(String email, String password, String confirmPassword) {
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
        if(!LoginUtils.validateConfirmPassword(password,confirmPassword)){
            return false;
        }
        return true;
    }


    public void register(String email, String password){

        LoginEntityRealm entityRealm =loginLocalRepositoryRealm.getExistUser(email);
        if(entityRealm!=null){
            getNavigator().showExistUserError(email);
        }else{
            login.setId(UUID.randomUUID().toString());
            login.setLogin(email);
            login.setPassword(password);
            loginLocalRepositoryRealm.saveUser(login);
            Prefs.putString(PrefsKeys.EMAIL, email);
            getNavigator().navigateToMovies();
        }

    }

    public void onRegisterClick(){
        getNavigator().register();
    }
}
