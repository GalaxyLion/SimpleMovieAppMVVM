package com.example.simplemovieappmvvm.data.repositories;


import com.example.simplemovieappmvvm.data.models.Movie;
import com.example.simplemovieappmvvm.services.login_db.entities.MovieEntity;

import java.util.List;

import io.reactivex.Observable;
import io.realm.Realm;

public class MovieLocalRepositoryImpl implements MovieRepository {

    @Override
    public void saveMovies(List<MovieEntity> movieEntities) {
        Realm mRealm = Realm.getDefaultInstance();
        mRealm.executeTransaction(realm -> realm.insertOrUpdate(movieEntities));
        mRealm.close();
    }

    @Override
    public void deleteMovies() {
        Realm.getDefaultInstance().executeTransaction(realm -> realm.where(MovieEntity.class)
                                    .findAll().deleteAllFromRealm());
    }

    @Override
    public List<MovieEntity> getMovies() {
        Realm realm = Realm.getDefaultInstance();
        List<MovieEntity> movieEntities = realm.where(MovieEntity.class)
                                        .findAll();

        List<MovieEntity> allMovies = null;
        if(movieEntities != null){
            allMovies = realm.copyFromRealm(movieEntities);
        }
        realm.close();

        return allMovies;
    }

    @Override
    public Observable<List<Movie>> search() {
        return null;
    }
}
