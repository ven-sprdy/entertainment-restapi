package com.prasaddy.entertainmentapp.service.language;

import com.prasaddy.entertainmentapp.io.entity.LanguageEntity;
import com.prasaddy.entertainmentapp.io.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public List<LanguageEntity> getLanguages() {
        return languageRepository.findAll();
    }

}
