package com.prasaddy.entertainmentapp.service.movie;

import com.prasaddy.entertainmentapp.io.entity.MovieEntity;
import com.prasaddy.entertainmentapp.io.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
