package com.wortex.backend.web.translator.mapper;

import com.wortex.backend.web.translator.model.Language;
import org.springframework.stereotype.Component;

@Component
public class LanguageToYandexLanguageMapper {

    public yandextranslate.model.Language map(Language language) {
        return yandextranslate.model.Language.valueOf(language.toString());
    }
}
