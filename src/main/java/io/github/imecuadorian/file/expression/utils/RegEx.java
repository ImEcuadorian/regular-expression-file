package io.github.imecuadorian.file.expression.utils;

public class RegEx {

    public static final String WEB_URL = "https?:\\/\\/(www\\.)?[a-zA-Z0-9\\-]+\\.[a-zA-Z]{2,}(\\S*)?";
    public static final String EMAIL = "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+";
    public static final String CREDIT_CARD = "(?:\\d{4}[- ]?){3}\\d{4}";
    public static final String CAMEL_CASE = "\\b([A-Z][a-z0-9]+)+\\b";

    private RegEx() {
        throw new UnsupportedOperationException("Utility class");
    }

}
