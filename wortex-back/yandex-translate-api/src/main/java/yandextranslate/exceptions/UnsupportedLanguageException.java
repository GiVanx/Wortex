package yandextranslate.exceptions;

public class UnsupportedLanguageException extends RuntimeException {
    public UnsupportedLanguageException(String language) {
        super("Language '" + language + "' is not supported.");
    }
}
