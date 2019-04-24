package com.example.simplemovieappmvvm.services.navigation.factories;

import android.app.Activity;
import android.content.Intent;

import com.example.simplemovieappmvvm.base.App;
import com.example.simplemovieappmvvm.screens.auth.AuthActivity;
import com.example.simplemovieappmvvm.services.navigation.Screen;


public class ScreenActivityFactory {

    public Intent getActivityByType(Screen screen){
        return new Intent(App.getInstance(),getActivityClassByType(screen));
    }

    private Class<? extends Activity> getActivityClassByType(Screen screen){
        switch (screen){
            case AUTH:
                return AuthActivity.class;
         /*   case MOVIE:
                return MovieActivity.class;
            case MOVIE_DETAILS:
                return MovieDetailsActivity.class;
            case PROFILE:
                return ProfileActivity.class;*/

                default:return AuthActivity.class;
        }
    }

}
