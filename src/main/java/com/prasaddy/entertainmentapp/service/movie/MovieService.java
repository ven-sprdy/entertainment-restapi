package com.prasaddy.entertainmentapp.service.movie;

import com.prasaddy.entertainmentapp.io.entity.MovieEntity;
import com.prasaddy.entertainmentapp.io.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieEntity> getMovies() {
        return movieRepository.findAll();
    }

    public List<MovieEntity> getByMovieName(String movieName) {
        return movieRepository.findByMovieNameIgnoreCaseContaining(movieName);
    }

    public List<MovieEntity> getMovieByLanguage(String language) {
        return movieRepository.findByLanguageIgnoreCaseContaining(language);
    }

    public List<MovieEntity> getDistinctMovies() {
        List<MovieEntity> sortedMovies = movieRepository.findAll().stream().sorted(Comparator.comparing(MovieEntity::getMovieName)).collect(Collectors.toList());
        List<MovieEntity> movies =  sortedMovies.stream().collect(Collectors.groupingBy(p -> p.getMovieName())).values().stream()
                .map(plans -> plans.stream().findFirst().get())
                .collect(Collectors.toList());
        return movies.stream().sorted(Comparator.comparing(MovieEntity::getMovieName)).collect(Collectors.toList());
    }

    public void postMovies(List<MovieEntity> movieEntities) {
        movieEntities.forEach(movie -> {
            if(movieRepository.findByMovieName(movie.getMovieName()) == null) {
                movieRepository.save(movie);
            }
        });
    }

    public void updateMovie(String id, MovieEntity movieEntity) {
        MovieEntity movie = movieRepository.findById(id).get();
        if(movie != null) {
            movie.setMovieName(movieEntity.getMovieName());
            movieRepository.save(movie);
        }
    }

    public List<String> getImageUrl() {
        List<String> imagePaths = new ArrayList<>();
        movieRepository.findAll().stream().forEach(movieEntity -> {
            if(movieEntity.getMovieImage() != null) {
                imagePaths.add(movieEntity.getMovieImage());
            }
        });
        return imagePaths;
    }
}
