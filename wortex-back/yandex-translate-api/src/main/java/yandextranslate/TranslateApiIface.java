package yandextranslate;

import yandextranslate.model.Translation;
import yandextranslate.model.TranslationDirection;

public interface TranslateApiIface {

    Translation translate(String text, TranslationDirection translationDirection);
}
