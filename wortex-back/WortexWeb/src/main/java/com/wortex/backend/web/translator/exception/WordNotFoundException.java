package com.wortex.backend.web.translator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Word not found or unable to translate")
public class WordNotFoundException extends RuntimeException {

    public WordNotFoundException(String word) {
        super("Word '" + word + "' not found or could not be translated.");
    }
}
