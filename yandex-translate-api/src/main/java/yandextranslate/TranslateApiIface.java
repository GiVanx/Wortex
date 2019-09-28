package yandextranslate;

import yandextranslate.model.Translation;

public interface TranslateApiIface {

    Translation translate(String text, TranslationDirection translationDirection);
}
