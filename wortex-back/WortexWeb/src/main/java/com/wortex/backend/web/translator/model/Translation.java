package com.wortex.backend.web.translator.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonId;

import java.util.List;

@Getter
@Setter
public class Translation {

    @BsonId
    private String word;
    private String pos;
    private String transcript;

    private List<Definition> definitions;

    @Override
    public String toString() {
        return "{" +
                "word='" + word + '\'' +
                ", pos='" + pos + '\'' +
                ", transcript='" + transcript + '\'' +
                ", definitions=" + definitions +
                '}';
    }
}
