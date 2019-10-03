package com.wortex.backend.web.translator.service;

import com.wortex.backend.web.translator.model.Translation;
import com.wortex.backend.web.translator.model.TranslationDirection;

public interface TranslationService {

    Translation translate(String word, TranslationDirection direction);
}
