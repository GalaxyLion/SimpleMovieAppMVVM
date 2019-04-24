package com.example.simplemovieappmvvm.data.repositories;


import com.example.simplemovieappmvvm.services.login_db.entities.LoginEntityRealm;

public interface LoginRepository {
   void saveUser(LoginEntityRealm loginEntity);
   LoginEntityRealm getExistUser(String login);
}
