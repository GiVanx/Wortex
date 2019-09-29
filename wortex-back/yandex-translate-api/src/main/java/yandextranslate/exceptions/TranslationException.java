package yandextranslate.exceptions;

import yandextranslate.TranslationDirection;

public class TranslationException extends RuntimeException {

    public TranslationException(String word, TranslationDirection translationDirection) {
        super("Could not translate word: " + word +
                " from " + translationDirection.getSource() +
                " to " + translationDirection.getTarget());
    }
}
