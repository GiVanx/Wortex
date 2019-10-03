package com.wortex.backend.web.translator.mapper;

import com.wortex.backend.web.translator.model.ExampleTranslation;
import org.springframework.stereotype.Component;

@Component
public class YandexExampleTranslationToModelExampleTranslation {

    ExampleTranslation map(yandextranslate.model.ExampleTranslation yandexExampleTranslation) {
        return new ExampleTranslation(yandexExampleTranslation.getText());
    }
}
