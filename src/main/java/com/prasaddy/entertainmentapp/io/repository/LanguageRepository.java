package com.prasaddy.entertainmentapp.io.repository;

import com.prasaddy.entertainmentapp.io.entity.LanguageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LanguageRepository extends MongoRepository<LanguageEntity, String> {
}
