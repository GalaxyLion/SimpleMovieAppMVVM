package com.example.simplemovieappmvvm.data.repositories;



import com.example.simplemovieappmvvm.data.mappers.MovieDtoMapper;
import com.example.simplemovieappmvvm.data.models.Movie;
import com.example.simplemovieappmvvm.services.login_db.entities.MovieEntity;
import com.example.simplemovieappmvvm.services.rest.RestAPI;
import com.example.simplemovieappmvvm.services.rest.RestClien;
import com.example.simplemovieappmvvm.services.rest.dto.ResultsItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MovieNetworkRepositoryImpl implements MovieRepository {

    private RestAPI restApi;
    private MovieDtoMapper movieDtoMapper;
    private String lang;

    public MovieNetworkRepositoryImpl() {
        restApi = RestClien.createApi();
        movieDtoMapper = new MovieDtoMapper();
        lang = Locale.getDefault().getLanguage();
    }

    @Override
    public Observable<List<Movie>> search() {
        return restApi.search(lang)
                .map(
                        it->{
                            List<Movie> movies = new ArrayList<>();
                            if(it.getResults()!=null){
                                for (ResultsItem item: it.getResults()) {
                                    movies.add(movieDtoMapper.from(item));
                                }
                            }
                            return movies;
                        }
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void saveMovies(List<MovieEntity> movieEntities) {

    }

    @Override
    public void deleteMovies() {

    }

    @Override
    public List<MovieEntity> getMovies() {
        return null;
    }
}
