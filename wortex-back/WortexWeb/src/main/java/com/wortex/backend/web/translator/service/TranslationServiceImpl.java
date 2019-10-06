package com.wortex.backend.web.translator.service;

import com.wortex.backend.web.translator.exception.WordNotFoundException;
import com.wortex.backend.web.translator.model.Translation;
import com.wortex.backend.web.translator.model.TranslationDirection;
import com.wortex.backend.web.translator.service.db.DbService;
import org.springframework.beans.factory.annotation.Autowired;

public class TranslationServiceImpl implements TranslationService {

    @Autowired
    private YandexTranslationService yandexTranslationService;

    @Autowired
    private DbService dbService;

    @Override
    public Translation translate(String word, TranslationDirection direction) {

        Translation translation = dbService.find(word);
        if (translation != null) {
            return translation;
        }
        translation = yandexTranslationService.translate(word, direction);
        if (translation == null) {
            throw new WordNotFoundException(word);
        } else {
            dbService.save(translation);
        }

        return translation;
    }
}
