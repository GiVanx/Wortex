package com.wortex.backend.web.translator.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yandextranslate.model.TranslationDirection;

@Component
public class TranslationDirectionToYandexTranslationDirectionMapper {

    @Autowired
    private LanguageToYandexLanguageMapper languageToYandexLanguageMapper;

    public TranslationDirection map(com.wortex.backend.web.translator.model.TranslationDirection direction) {
        return new TranslationDirection(
                languageToYandexLanguageMapper.map(direction.getSource()),
                languageToYandexLanguageMapper.map(direction.getTarget()));
    }
}
