package com.wortex.backend.web.translator.mapper;

import com.wortex.backend.web.translator.model.Definition;
import com.wortex.backend.web.translator.model.Example;
import com.wortex.backend.web.translator.model.Meaning;
import com.wortex.backend.web.translator.model.Synonym;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yandextranslate.model.Tr;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class YandexTrToModelDefinitionMapper {

    @Autowired
    private YandexMeaningToModelMeaningMapper yandexMeaningToModelMeaningMapper;

    @Autowired
    private YandexSynonymToModelSynonymMapper yandexSynonymToModelSynonymMapper;

    @Autowired
    private YandexExampleToModelExampleMapper yandexExampleToModelExampleMapper;

    public Definition map(Tr yandexTranslation) {

        Definition modelDefinition = new Definition();

        List<Synonym> synonyms = new ArrayList<>();
        synonyms.add(new Synonym(yandexTranslation.getText(), yandexTranslation.getPos()));

        if (yandexTranslation.getSynonyms() != null) {
            synonyms.addAll(yandexTranslation.getSynonyms().stream().map(yandexSynonymToModelSynonymMapper::map)
                    .collect(Collectors.toList()));
        }

        List<Meaning> meanings = new ArrayList<>();
        if (yandexTranslation.getMeanings() != null) {
            meanings.addAll(yandexTranslation.getMeanings().stream().map(yandexMeaningToModelMeaningMapper::map)
                    .collect(Collectors.toList()));
        }

        List<Example> examples = new ArrayList<>();
        if (yandexTranslation.getExamples() != null) {
            examples.addAll(yandexTranslation.getExamples().stream().map(yandexExampleToModelExampleMapper::map)
                    .collect(Collectors.toList()));
        }

        modelDefinition.setMeanings(meanings);
        modelDefinition.setExamples(examples);
        modelDefinition.setSynonyms(synonyms);

        return modelDefinition;
    }
}
