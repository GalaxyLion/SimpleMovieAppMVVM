package com.example.simplemovieappmvvm.utils;



public class LoginUtils {

    public static boolean validateLogin(String loginText) {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(loginText).matches()) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean validatePassword(String password) {
        if (password.length() < 4 || password.length() > 20) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validateConfirmPassword(String confirmPassword, String password) {
        if (!confirmPassword.equals(password)) {
            return false;
        } else {
            return true;
        }

    }

}
