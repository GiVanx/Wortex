package com.wortex.backend.web.controller;

import com.wortex.backend.web.translator.model.Language;
import com.wortex.backend.web.translator.model.Translation;
import com.wortex.backend.web.translator.model.TranslationDirection;
import com.wortex.backend.web.translator.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/translate")
@RestController
public class TranslatorController {

    @Autowired
    private TranslationService translationService;

    @GetMapping("/{word}")
    public Translation translateWord(@PathVariable String word) {

        return translationService.translate(word, TranslationDirection.of(Language.DE, Language.EN));
    }
}
