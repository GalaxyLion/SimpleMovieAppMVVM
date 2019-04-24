package com.example.simplemovieappmvvm.services.login_db.entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class LoginEntityRealm extends RealmObject {

    @PrimaryKey
    private String id;


    private String login;
    private String password;

    public LoginEntityRealm() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
