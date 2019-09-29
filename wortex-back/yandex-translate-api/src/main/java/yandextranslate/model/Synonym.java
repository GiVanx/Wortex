package yandextranslate.model;

import lombok.Getter;

@Getter
public class Synonym {

    String text;
    String pos;

    @Override
    public String toString() {
        return "{" +
                "text='" + text + '\'' +
                ", pos='" + pos + '\'' +
                '}';
    }
}
