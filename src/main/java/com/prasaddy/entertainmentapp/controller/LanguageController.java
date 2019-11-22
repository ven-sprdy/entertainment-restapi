package com.prasaddy.entertainmentapp.controller;

import com.prasaddy.entertainmentapp.io.entity.LanguageEntity;
import com.prasaddy.entertainmentapp.service.language.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 1800)
@RestController
@RequestMapping("/api/languages")
public class LanguageController {

//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @GetMapping
//    public void getLanguages() {
//        Iterator<String> it = mongoTemplate.getCollection("movies").distinct("language", String.class).iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next().toString());
//        }
//    }

    @Autowired
    private LanguageService languageService;

    @GetMapping
    public @ResponseBody List<LanguageEntity> getLanguages() {
        return languageService.getLanguages().stream()
                .sorted(Comparator.comparing(LanguageEntity::getLanguageName)).collect(Collectors.toList());
    }

}
