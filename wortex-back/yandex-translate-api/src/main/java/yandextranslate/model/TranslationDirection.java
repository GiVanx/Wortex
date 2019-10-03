package yandextranslate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TranslationDirection {

    private Language source;
    private Language target;

    public static TranslationDirection of(Language source, Language target) {
        return new TranslationDirection(source, target);
    }

    @Override
    public String toString() {
        return "{" +
                "source=" + source +
                ", target=" + target +
                '}';
    }
}
