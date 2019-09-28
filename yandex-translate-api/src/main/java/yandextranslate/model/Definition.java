package yandextranslate.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class Definition {

    String text;
    String pos;

    @SerializedName("ts")
    String transcription;

    @SerializedName("tr")
    List<Tr> translations;

    @Override
    public String toString() {
        return "{" +
                "text='" + text + '\'' +
                ", pos='" + pos + '\'' +
                ", transcription='" + transcription + '\'' +
                ", translations=" + translations +
                '}';
    }
}
