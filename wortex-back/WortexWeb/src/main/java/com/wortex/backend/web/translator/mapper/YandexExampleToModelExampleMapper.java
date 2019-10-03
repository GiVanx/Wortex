package com.wortex.backend.web.translator.mapper;

import com.wortex.backend.web.translator.model.Example;
import com.wortex.backend.web.translator.model.ExampleTranslation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class YandexExampleToModelExampleMapper {

    @Autowired
    YandexExampleTranslationToModelExampleTranslation yandexExampleTranslationToModelExampleTranslation;

    Example map(yandextranslate.model.Example yandexExample) {

        Example modelExample = new Example();
        modelExample.setText(yandexExample.getText());

        List<ExampleTranslation> modelExampleTranslation = yandexExample.getTranslations()
                .stream().map(yandexExampleTranslationToModelExampleTranslation::map)
                .collect(Collectors.toList());

        modelExample.setTranslations(modelExampleTranslation);

        return modelExample;
    }
}
