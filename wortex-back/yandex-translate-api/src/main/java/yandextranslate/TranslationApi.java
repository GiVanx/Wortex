package yandextranslate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import yandextranslate.exceptions.TranslationException;
import yandextranslate.model.Translation;
import yandextranslate.model.TranslationDirection;
import yandextranslate.utils.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TranslationApi implements TranslateApiIface {

    private static final String YANDEX_TRANSLATE_URL_BASE = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup";
    private static final String LANG_PARAM = "lang";
    private static final String LANG_PARAM_DELIMITER = "-";
    private static final String TEXT_PARAM = "text";
    private static final String API_KEY_PARAM = "key";
    private String yandexTranslateApiKey;
    private static TranslationApi translationApi;
    private Gson gson = new GsonBuilder().create();

    public static TranslateApiIface translateApi(String apiKey) {
        if (translationApi == null) {
            translationApi = new TranslationApi();
            translationApi.setApiKey(apiKey);
        }
        return translationApi;
    }

    private void setApiKey(String apiKey) {
        this.yandexTranslateApiKey = apiKey;
    }

    @Override
    public Translation translate(String text, TranslationDirection translationDirection) throws TranslationException {

        Map<String, String> params = new HashMap<>();
        params.put(LANG_PARAM, translationDirection.getSource().value() + LANG_PARAM_DELIMITER + translationDirection.getTarget().value());
        params.put(TEXT_PARAM, text);
        params.put(API_KEY_PARAM, yandexTranslateApiKey);

        String reqParams = params.entrySet().stream().map(Util.funcWrapper(e -> URLEncoder.encode(e.getKey(), "UTF-8") + "=" +
                URLEncoder.encode(e.getValue(), "UTF-8"))).collect(Collectors.joining("&"));

        String fullUrl = YANDEX_TRANSLATE_URL_BASE + "?" + reqParams;

        URL url;
        try {
            url = new URL(fullUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuffer response = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            in.close();

            return gson.fromJson(response.toString(), Translation.class);

        } catch (Exception e) {
            e.printStackTrace();
            throw new TranslationException(text, translationDirection);
        }
    }
}
