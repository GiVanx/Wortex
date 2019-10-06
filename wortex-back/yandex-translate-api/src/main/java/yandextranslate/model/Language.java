package yandextranslate.model;

public enum Language {

    DE("de", "deutsch"),
    EN("en", "english");

    String lang;
    String fullName;

    Language(String lang, String fullName) {
        this.lang = lang;
        this.fullName = fullName;
    }

    public String value() {
        return lang;
    }

    public String getFullName() {
        return fullName;
    }
}
