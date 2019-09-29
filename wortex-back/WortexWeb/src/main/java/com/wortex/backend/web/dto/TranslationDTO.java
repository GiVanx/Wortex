package com.wortex.backend.web.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class TranslationDTO {

    private String word;
    private String pos;
    private String transcript;

    private List<DefinitionDTO> translations;
}
