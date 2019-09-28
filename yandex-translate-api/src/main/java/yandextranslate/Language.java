package yandextranslate;

public enum Language {

    DE("de"),
    EN("en");

    String lang;

    Language(String lang) {
        this.lang = lang;
    }

    String value() {
        return lang;
    }
}
