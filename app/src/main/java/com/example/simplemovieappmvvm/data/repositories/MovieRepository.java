package com.example.simplemovieappmvvm.data.repositories;

import com.example.simplemovieappmvvm.data.models.Movie;
import com.example.simplemovieappmvvm.services.login_db.entities.MovieEntity;

import java.util.List;

import io.reactivex.Observable;

public interface MovieRepository {
    Observable<List<Movie>> search();

    void saveMovies(List<MovieEntity> movieEntities);
    void deleteMovies();
    List<MovieEntity> getMovies();
}
