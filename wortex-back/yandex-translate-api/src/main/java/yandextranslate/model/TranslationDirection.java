package yandextranslate.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranslationDirection {

    private Language source;
    private Language target;

    public static TranslationDirection of(Language source, Language target) {
        TranslationDirection direction = new TranslationDirection();
        direction.setSource(source);
        direction.setTarget(target);
        return direction;
    }

}
