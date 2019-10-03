package com.wortex.backend.web.translator.service;

import com.wortex.backend.web.translator.model.Translation;
import com.wortex.backend.web.translator.model.TranslationDirection;
import org.springframework.beans.factory.annotation.Autowired;

public class TranslationServiceImpl implements TranslationService {

    @Autowired
    private YandexTranslationService yandexTranslationService;

    @Override
    public Translation translate(String word, TranslationDirection direction) {

        return yandexTranslationService.translate(word, direction);
    }
}
