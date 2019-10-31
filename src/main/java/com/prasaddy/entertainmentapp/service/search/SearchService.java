package com.prasaddy.entertainmentapp.service.search;

import com.prasaddy.entertainmentapp.io.entity.MovieEntity;
import com.prasaddy.entertainmentapp.io.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieEntity> searchByMovieName(String movieName) {
        return movieRepository.findByMovieNameIgnoreCaseContaining(movieName);
    }

    public List<MovieEntity> searchByDirector(String directedBy) {
        return movieRepository.findByDirectedByIgnoreCaseContaining(directedBy);
    }

    public List<MovieEntity> searchByMusicDirector(String musicBy) {
        return movieRepository.findByMusicByIgnoreCaseContaining(musicBy);
    }

    public List<MovieEntity> searchByCast(String starring) {
        return movieRepository.findByStarringIgnoreCaseContaining(starring);
    }

    public List<MovieEntity> searchByLanguage(String language) {
        return movieRepository.findByLanguageIgnoreCaseContaining(language);
    }
}
