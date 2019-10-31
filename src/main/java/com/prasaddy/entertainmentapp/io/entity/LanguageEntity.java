package com.prasaddy.entertainmentapp.io.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "languages")
public class LanguageEntity {

    @Id
    private String languageId;
    private String languageName;

    public LanguageEntity() {
    }

    public LanguageEntity(String languageId, String languageName) {
        this.languageId = languageId;
        this.languageName = languageName;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

}
