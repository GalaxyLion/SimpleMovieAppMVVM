package com.example.simplemovieappmvvm.data.repositories;



import com.example.simplemovieappmvvm.services.login_db.entities.LoginEntityRealm;

import io.realm.Realm;

public class LoginLocalRepositoryRealmImpl implements LoginRepository {

    @Override
    public void saveUser(LoginEntityRealm loginEntity) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(mRealm -> mRealm.insert(loginEntity));
        realm.close();
    }

    @Override
    public LoginEntityRealm getExistUser(String login) {
        Realm realm = Realm.getDefaultInstance();
        LoginEntityRealm user = realm.where(LoginEntityRealm.class).equalTo("login", login).findFirst();
        realm.close();
        return user;
    }
}
