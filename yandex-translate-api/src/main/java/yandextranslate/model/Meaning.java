package yandextranslate.model;

import lombok.Getter;

@Getter
public class Meaning {

    String text;

    @Override
    public String toString() {
        return "{" +
                "text='" + text + '\'' +
                '}';
    }
}
