package com.wortex.backend.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExampleDTO {

    private String text;

    private List<ExampleTranslationDTO> translations;
}
