package com.prasaddy.entertainmentapp.controller;

import com.prasaddy.entertainmentapp.io.entity.MovieEntity;
import com.prasaddy.entertainmentapp.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 1800)
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping
    public @ResponseBody List<MovieEntity> getAllMovies() {
        return movieService.getMovies();
    }

    @PreAuthorize("hasAuthority('admin') or hasAuthority('user')")
    @GetMapping("/languages/{movieName}")
    public @ResponseBody List<MovieEntity> getByMovieName(@PathVariable String movieName) {
        return movieService.getByMovieName(movieName).stream()
                .sorted(Comparator.comparing(MovieEntity::getMovieName)).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('admin') or hasAuthority('user')")
    @GetMapping("/{language}")
    public @ResponseBody List<MovieEntity> getMovieByLanguage(@PathVariable String language) {
        return movieService.getMovieByLanguage(language).stream()
                .sorted(Comparator.comparing(MovieEntity::getMovieName)).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/")
    public @ResponseBody List<MovieEntity> getDistinctMovies() {
        return movieService.getDistinctMovies();
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/images")
    public @ResponseBody List<String> getImageUrlPaths() {
        return movieService.getImageUrl();
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping
    public ResponseEntity<String> postMovies(@RequestBody List<MovieEntity> movieEntities) {
        movieService.postMovies(movieEntities);
        return new ResponseEntity<>("Inserted", HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PutMapping("/{movieId}")
    public ResponseEntity<String> postMovies(@PathVariable String movieId, @RequestBody MovieEntity movieEntitie) {
        movieService.updateMovie(movieId, movieEntitie);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable String movieId) {
        movieService.deleteMovie(movieId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
