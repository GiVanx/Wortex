package com.wortex.backend.web.translator.service;

import com.wortex.backend.web.translator.model.Translation;

public interface TranslationNormalizer {

    Translation normalize(Translation word);
}
