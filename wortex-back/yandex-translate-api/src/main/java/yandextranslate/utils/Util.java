package yandextranslate.utils;

import java.util.function.Function;

public class Util {

    public static <T, R> Function<T, R> funcWrapper(ThrowingFunction<T, R> func) {
        return i -> {
            try {
                return func.apply(i);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
