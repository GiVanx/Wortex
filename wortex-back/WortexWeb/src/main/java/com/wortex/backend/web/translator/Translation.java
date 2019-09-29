package com.wortex.backend.web.translator;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Translation {

    private String word;
    private String pos;
    private String transcript;

    private List<Definition> translations;
}
