package yandextranslate.model;

import lombok.Getter;

@Getter
public class ExampleTranslation {

    String text;

    @Override
    public String toString() {
        return "{" +
                "text='" + text + '\'' +
                '}';
    }
}
