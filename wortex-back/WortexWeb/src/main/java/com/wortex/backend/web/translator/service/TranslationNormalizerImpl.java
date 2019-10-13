package com.wortex.backend.web.translator.service;

import com.wortex.backend.web.translator.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TranslationNormalizerImpl implements TranslationNormalizer {

    private Synonym setToLowercase(final Synonym synonym) {

        synonym.setPos(synonym.getPos().toLowerCase());
        synonym.setText(synonym.getText().toLowerCase());
        return synonym;
    }

    private Meaning setToLowercase(final Meaning meaning) {
        meaning.setText(meaning.getText().toLowerCase());
        return meaning;
    }

    private ExampleTranslation setToLowercase(ExampleTranslation exampleTranslation) {
        exampleTranslation.setText(exampleTranslation.getText().toLowerCase());
        return exampleTranslation;
    }

    private Example setToLowercase(final Example example) {
        example.setText(example.getText().toLowerCase());
        example.getTranslations().forEach(t -> setToLowercase(t));
        return example;
    }

    private Definition setToLowercase(final Definition definition) {

        definition.getSynonyms().forEach(s -> setToLowercase(s));
        definition.getMeanings().forEach(m -> setToLowercase(m));
        definition.getExamples().forEach(e -> setToLowercase(e));
        return definition;
    }

    private Translation setToLowercase(final Translation translation) {

        translation.setWord(translation.getWord().toLowerCase());
        translation.setPos(translation.getPos().toLowerCase());

        final List<Definition> definition = translation.getDefinitions();

        definition.forEach(d -> setToLowercase(d));
        return translation;
    }

    @Override
    public Translation normalize(Translation translation) {

        return setToLowercase(translation);
    }
}
