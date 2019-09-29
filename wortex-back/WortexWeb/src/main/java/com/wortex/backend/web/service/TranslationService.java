package com.wortex.backend.web.service;

import com.wortex.backend.web.translator.Translation;
import com.wortex.backend.web.translator.TranslationDirection;

public interface TranslationService {

    Translation translate(String word, TranslationDirection direction);
}
