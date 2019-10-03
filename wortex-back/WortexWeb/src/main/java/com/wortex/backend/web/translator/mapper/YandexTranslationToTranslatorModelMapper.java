package com.wortex.backend.web.translator.mapper;

import com.wortex.backend.web.translator.model.Definition;
import com.wortex.backend.web.translator.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class YandexTranslationToTranslatorModelMapper {

    @Autowired
    private YandexTrToModelDefinitionMapper yandexTrToModelDefinitionMapper;

    public Translation map(yandextranslate.model.Translation yandexModel) {

        Translation translation = new Translation();
        yandextranslate.model.Definition yandexDefintion = yandexModel.getDefinition().iterator().next();
        translation.setWord(yandexDefintion.getText());
        translation.setPos(yandexDefintion.getPos());

        translation.setTranscript(yandexDefintion.getTranscription());

        List<Definition> defs = yandexDefintion.getTranslations().stream().map(yandexTrToModelDefinitionMapper::map)
                .collect(Collectors.toList());

        translation.setDefinitions(defs);

        return translation;
    }
}
