package com.wortex.backend.web.translator.service;

import com.wortex.backend.web.translator.exception.WordNotFoundException;
import com.wortex.backend.web.translator.model.Translation;
import com.wortex.backend.web.translator.model.TranslationDirection;
import com.wortex.backend.web.translator.service.db.DbService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class TranslationServiceImpl implements TranslationService {

    private static final Logger log = LogManager.getLogger(TranslationServiceImpl.class);

    @Autowired
    private YandexTranslationService yandexTranslationService;

    @Autowired
    private DbService dbService;

    @Autowired
    private TranslationNormalizer translationNormalizer;

    @Override
    public Translation translate(String word, TranslationDirection direction) {

        log.info("Translating '" + word + "', direction '" + direction + "'");

        Translation translation = dbService.find(word);
        if (translation != null) {
            log.info("Word translation found in database: " + translation);
            return translation;
        }
        log.info("Word translation not found in database");
        translation = yandexTranslationService.translate(word, direction);
        if (translation == null) {
            throw new WordNotFoundException(word);
        } else {
            translation = translationNormalizer.normalize(translation);
            dbService.save(translation);
        }

        return translation;
    }
}
