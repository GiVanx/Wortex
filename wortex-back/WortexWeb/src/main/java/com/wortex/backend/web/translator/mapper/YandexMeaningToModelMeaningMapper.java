package com.wortex.backend.web.translator.mapper;

import com.wortex.backend.web.translator.model.Meaning;
import org.springframework.stereotype.Component;

@Component
public class YandexMeaningToModelMeaningMapper {

    Meaning map(yandextranslate.model.Meaning yandexMeaning) {

        return new Meaning(yandexMeaning.getText());
    }
}
