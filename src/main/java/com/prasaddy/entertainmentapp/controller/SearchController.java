package com.prasaddy.entertainmentapp.controller;

import com.prasaddy.entertainmentapp.io.entity.MovieEntity;
import com.prasaddy.entertainmentapp.service.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class SearchController {

    @Autowired
    private SearchService searchService;

//        @GetMapping("/search/{movieName}")
//        public @ResponseBody List<MovieEntity> searchByMovieName(@PathVariable String movieName) {
//          return searchService.searchByMovieName(movieName);
//        }

    @GetMapping("/searchbymovies")
    public @ResponseBody
    List<MovieEntity> searchByMovieName(@RequestParam String movieName) {
        return searchService.searchByMovieName(movieName);
    }

    @GetMapping("/searchbydirector")
    public @ResponseBody List<MovieEntity> searchByDirector(@RequestParam String directedBy) {
        return searchService.searchByDirector(directedBy);
    }

    @GetMapping("/searchbymusicdirector")
    public @ResponseBody List<MovieEntity> searchByMusicDirector(@RequestParam String musicBy) {
        return searchService.searchByMusicDirector(musicBy);
    }

    @GetMapping("/searchbycast")
    public @ResponseBody List<MovieEntity> searchByCast(@RequestParam String starring) {
        return searchService.searchByCast(starring);
    }

    @GetMapping("/searchbylanguage")
    public @ResponseBody List<MovieEntity> searchByLanguage(@RequestParam String language) {
        return searchService.searchByLanguage(language);
    }

}
