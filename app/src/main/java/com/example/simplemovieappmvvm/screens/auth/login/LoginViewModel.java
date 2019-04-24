package com.example.simplemovieappmvvm.screens.auth.login;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.widget.Toast;

import com.example.simplemovieappmvvm.R;
import com.example.simplemovieappmvvm.base.App;
import com.example.simplemovieappmvvm.data.repositories.LoginLocalRepositoryRealmImpl;
import com.example.simplemovieappmvvm.data.repositories.LoginRepository;
import com.example.simplemovieappmvvm.services.Navigator;
import com.example.simplemovieappmvvm.services.login_db.entities.LoginEntityRealm;
import com.example.simplemovieappmvvm.services.navigation.Screen;
import com.example.simplemovieappmvvm.services.navigation.ScreenType;
import com.example.simplemovieappmvvm.utils.LoginUtils;
import com.example.simplemovieappmvvm.utils.PrefsKeys;
import com.pixplicity.easyprefs.library.Prefs;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<String> login;
    public MutableLiveData<String> password;
    private LoginRepository loginLocalRepositoryRealm;
    private Navigator navigator;



    public LoginViewModel() {
        login = new MutableLiveData<>();
        password = new MutableLiveData<>();
        loginLocalRepositoryRealm = new LoginLocalRepositoryRealmImpl();
    }

    public void onLoginClick(){
        if(LoginUtils.validateLogin(login.getValue()) && LoginUtils.validatePassword(password.getValue())){
            LoginEntityRealm loginEntityRealm = loginLocalRepositoryRealm.getExistUser(login.getValue());
            if(loginEntityRealm!=null) {
                Prefs.putString(PrefsKeys.EMAIL, login.getValue());
                navigator.navigateTo(Screen.MOVIE, ScreenType.ACTIVITY);
            }
        }else{
            showNotExistUser();
        }
    }

    public void onRegisterClick(){
       navigator.navigateTo(Screen.REGISTER, ScreenType.FRAGMENT);
    }

    private void showNotExistUser(){
        Toast.makeText(App.getInstance().getApplicationContext(),
                App.getInstance().getApplicationContext().getString(R.string.user) + " " +
                        App.getInstance().getApplicationContext().getString(R.string.user_not_exist),
                Toast.LENGTH_SHORT).show();
    }


    public void setNavigator(Navigator navigator){
        this.navigator = navigator;
    }
}
