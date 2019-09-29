package yandextranslate.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class Translation {

    transient Head head;

    @SerializedName("def")
    List<Definition> definition;

    @Override
    public String toString() {
        return "Translation{" +
                "definition=" + definition +
                '}';
    }
}
