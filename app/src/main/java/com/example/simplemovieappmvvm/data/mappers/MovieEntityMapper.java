package com.example.simplemovieappmvvm.data.mappers;


import com.example.simplemovieappmvvm.data.models.Movie;
import com.example.simplemovieappmvvm.services.login_db.entities.MovieEntity;

import java.util.UUID;

public class MovieEntityMapper implements  Mapper<MovieEntity, Movie> {

    @Override
    public Movie from(MovieEntity data) {
        return new Movie(data.getOverview(),
                data.getOriginalLanguage(),
                data.getTitle(),
                data.getPosterPath(),
                data.getReleaseDate(),
                data.getVoteAverage(),
                data.getPopularity());
    }

    @Override
    public MovieEntity to(Movie model) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setId(UUID.randomUUID().toString());
        movieEntity.setOriginalLanguage(model.getOriginalLanguage());
        movieEntity.setOverview(model.getOverview());
        movieEntity.setPopularity(model.getPopularity());
        movieEntity.setPosterPath(model.getPosterPath());
        movieEntity.setReleaseDate(model.getReleaseDate());
        movieEntity.setTitle(model.getTitle());
        movieEntity.setVoteAverage(model.getVoteAverage());
        return movieEntity;
    }
}
