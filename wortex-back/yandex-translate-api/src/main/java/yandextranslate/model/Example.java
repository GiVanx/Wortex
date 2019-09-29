package yandextranslate.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class Example {

    String text;

    @SerializedName("tr")
    List<ExampleTranslation> translations;

    @Override
    public String toString() {
        return "{" +
                "text='" + text + '\'' +
                ", translations=" + translations +
                '}';
    }
}
