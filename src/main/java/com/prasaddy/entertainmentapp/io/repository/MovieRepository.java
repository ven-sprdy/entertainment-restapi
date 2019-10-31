package com.prasaddy.entertainmentapp.io.repository;

import com.prasaddy.entertainmentapp.io.entity.MovieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<MovieEntity, String> {
    MovieEntity findByMovieName(String movieName);
    List<MovieEntity> findByMovieNameIgnoreCaseContaining(String movieName);
    List<MovieEntity> findByDirectedByIgnoreCaseContaining(String director);
    List<MovieEntity> findByMusicByIgnoreCaseContaining(String music);
    List<MovieEntity> findByStarringIgnoreCaseContaining(String starring);
    List<MovieEntity> findByLanguageIgnoreCaseContaining(String language);
}
