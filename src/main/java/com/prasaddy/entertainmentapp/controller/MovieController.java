package com.prasaddy.entertainmentapp.controller;

import com.prasaddy.entertainmentapp.io.entity.MovieEntity;
import com.prasaddy.entertainmentapp.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 1800)
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public @ResponseBody List<MovieEntity> getAllMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/languages/{movieName}")
    public @ResponseBody List<MovieEntity> getByMovieName(@PathVariable String movieName, HttpServletResponse response) {
        return movieService.getByMovieName(movieName).stream()
                .sorted(Comparator.comparing(MovieEntity::getMovieName)).collect(Collectors.toList());
    }

    @GetMapping("/{language}")
    public @ResponseBody List<MovieEntity> getMovieByLanguage(@PathVariable String language, HttpServletResponse response) {
        return movieService.getMovieByLanguage(language).stream()
                .sorted(Comparator.comparing(MovieEntity::getMovieName)).collect(Collectors.toList());
    }
}
