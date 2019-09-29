package yandextranslate.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class Tr {

    String text;
    String pos;

    @SerializedName("syn")
    List<Synonym> synonyms;

    @SerializedName("mean")
    List<Meaning> meanings;

    @SerializedName("ex")
    List<Example> examples;

    @Override
    public String toString() {
        return "{" +
                "text='" + text + '\'' +
                ", pos='" + pos + '\'' +
                ", synonyms=" + synonyms +
                ", meanings=" + meanings +
                ", examples=" + examples +
                '}';
    }
}
