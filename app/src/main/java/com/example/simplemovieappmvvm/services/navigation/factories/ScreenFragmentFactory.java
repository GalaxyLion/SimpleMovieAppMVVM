package com.example.simplemovieappmvvm.services.navigation.factories;


import android.support.v4.app.Fragment;

import com.example.simplemovieappmvvm.base.App;
import com.example.simplemovieappmvvm.screens.auth.login.LoginFragment;
import com.example.simplemovieappmvvm.services.navigation.Screen;


public class ScreenFragmentFactory {

    public Fragment getFragmentByType(Screen screen){
        Class<? extends Fragment> clazz = getFragmentClassByType(screen);
        return Fragment.instantiate(App.getInstance(),clazz.getName());
    }

    public Class<? extends Fragment> getFragmentClassByType(Screen screen) {
        switch (screen){
         /*   case LOGIN:
                return LoginFragment.class;
            case REGISTER:
                return RegisterFragment.class;*/

                default: return  LoginFragment.class;
        }
    }
}
