package com.example.simplemovieappmvvm.screens.auth.register;

public interface RegisterNavigator {

    void navigateToMovies();

    void showExistUserError(String login);

    void showRegisterError();

    void register();
}
