package com.wortex.backend.web.translator.service;

import com.wortex.backend.web.translator.mapper.TranslationDirectionToYandexTranslationDirectionMapper;
import com.wortex.backend.web.translator.mapper.YandexTranslationToTranslatorModelMapper;
import com.wortex.backend.web.translator.model.Translation;
import com.wortex.backend.web.translator.model.TranslationDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yandextranslate.TranslateApiIface;

@Component
public class YandexTranslationService implements TranslationService {

    @Autowired
    private TranslateApiIface translateApi;

    @Autowired
    private YandexTranslationToTranslatorModelMapper yandexTranslationToTranslatorModelMapper;

    @Autowired
    private TranslationDirectionToYandexTranslationDirectionMapper translationDirectionToYandexTranslationDirectionMapper;

    @Override
    public Translation translate(String word, TranslationDirection direction) {

        yandextranslate.model.Translation yandexTranslation =
                translateApi.translate(word, translationDirectionToYandexTranslationDirectionMapper.map(direction));

        if (yandexTranslation == null) {
            return null;
        }
        return yandexTranslationToTranslatorModelMapper.map(yandexTranslation);
    }
}
