package S3_T01.S3_T01_n2exercici1;

import java.util.HashMap;
import java.util.Map;

public enum Country {
    DK("Denmark", "^[0-9]{4}$", "^[0-9]{8}$"),
    ES("Spain", "^[0-9]{5}$", "^[0-9]{9}$" ),
    UK("United Kingdom", "^[A-Z]{1,2}[0-9][A-Z0-9]? ?[0-9][A-Z]{2}$", "^[0-9]{11}$");

    public final String value;
    public final String regexPhoneNumber;
    public final String regexPostCode;

    private static final Map<String, String> BY_VALUE = new HashMap<>();
    private static final Map<String, String> BY_REGEX_POST_CODE = new HashMap<>();
    private static final Map<String, String> BY_REGEX_PHONE_NUMBER = new HashMap<>();

    static {
        for(Country c: values()) {
            BY_VALUE.put(c.value, c.value);
            BY_REGEX_POST_CODE.put(c.value, c.regexPostCode);
            BY_REGEX_PHONE_NUMBER.put(c.value, c.regexPhoneNumber);
        }
    }

    private Country(String value, String regexPostCode, String regexPhoneNumber) {
        this.value = value;
        this.regexPostCode = regexPostCode;
        this.regexPhoneNumber = regexPhoneNumber;
    }

    public String getValue() {
        return value;
    }


    public static String valueOfValue(String value) {
        return BY_VALUE.get(value);
    }

    public static String valueOfRegexPostCode(String value) {
        return BY_REGEX_POST_CODE.get(value);
    }

    public static String valueOfRegexPhoneNumber(String value) {
        return BY_REGEX_PHONE_NUMBER.get(value);
    }


    public static boolean findByValue(String value) {
        boolean found = false;
        for (Country country : values()) {
            if (country.getValue().equalsIgnoreCase(value)) {
                found = true;
            }
        }
        return found;
    }
}
