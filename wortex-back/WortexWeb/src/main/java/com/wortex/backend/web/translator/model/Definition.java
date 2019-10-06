package com.wortex.backend.web.translator.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Definition {

    List<Synonym> synonyms;
    List<Meaning> meanings;
    List<Example> examples;

    @Override
    public String toString() {
        return "{" +
                "synonyms=" + synonyms +
                ", meanings=" + meanings +
                ", examples=" + examples +
                '}';
    }
}
