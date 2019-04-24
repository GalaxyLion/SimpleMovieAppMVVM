package com.example.simplemovieappmvvm.services;

import android.os.Bundle;


import com.example.simplemovieappmvvm.services.navigation.Screen;
import com.example.simplemovieappmvvm.services.navigation.ScreenType;


public interface Navigator {
    void navigateTo(Screen screen, ScreenType type);
    void navigateTo(Screen screen, ScreenType type, Bundle args);
}
