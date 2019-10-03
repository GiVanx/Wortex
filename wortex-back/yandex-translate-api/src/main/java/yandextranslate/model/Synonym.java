package yandextranslate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
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
