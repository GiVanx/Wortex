package com.wortex.backend.web.translator;

public enum Language {

    DE("de"),
    EN("en");

    String lang;

    Language(String lang) {
        this.lang = lang;
    }

    public String value() {
        return lang;
    }
}
