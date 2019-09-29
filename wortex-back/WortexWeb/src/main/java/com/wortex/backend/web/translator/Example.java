package com.wortex.backend.web.translator;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Example {

    private String text;

    private List<ExampleTranslation> translations;
}
