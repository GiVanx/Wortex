package com.wortex.backend.web.translator.mapper;

import com.wortex.backend.web.translator.model.Synonym;
import org.springframework.stereotype.Component;

@Component
public class YandexSynonymToModelSynonymMapper {

    public Synonym map(yandextranslate.model.Synonym synonym) {

        return new Synonym(synonym.getText(), synonym.getPos());
    }
}
