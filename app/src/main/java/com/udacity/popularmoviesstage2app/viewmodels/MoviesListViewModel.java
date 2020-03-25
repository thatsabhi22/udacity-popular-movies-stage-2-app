package com.udacity.popularmoviesstage2app.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.udacity.popularmoviesstage2app.models.Movie;
import com.udacity.popularmoviesstage2app.utils.MovieRepository;

import java.util.List;

public class MoviesListViewModel extends AndroidViewModel {

    private LiveData<List<Movie>> movieList;
    private MovieRepository movieRepository;

    public MoviesListViewModel(@NonNull Application application) {
        super(application);
        movieRepository = MovieRepository.getInstance(application.getApplicationContext());
        this.movieList = movieRepository.getMovies("popular");
    }

    public LiveData<List<Movie>> getMovieList(String sort_type) {
        return movieRepository.getMovies(sort_type);
    }

    public LiveData<List<Movie>> getMovieListFromDB() {
        return movieRepository.getMovieListFromDB();
    }
}