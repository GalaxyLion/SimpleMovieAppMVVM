package com.example.simplemovieappmvvm.data.mappers;


import com.example.simplemovieappmvvm.data.models.Movie;
import com.example.simplemovieappmvvm.services.rest.dto.ResultsItem;

public class MovieDtoMapper implements Mapper<ResultsItem, Movie> {

    @Override
    public Movie from(ResultsItem data) {
        return new Movie(
                data.getOverview(),
                data.getOriginalLanguage(),
                data.getTitle(),
                data.getPosterPath(),
                data.getReleaseDate(),
                data.getVoteAverage(),
                data.getPopularity()
                );
    }

    @Override
    public ResultsItem to(Movie model) {
        return null;
    }
}
