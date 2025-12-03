package pay.tech.test.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Currency {
    EUR("EUR"),
    USD("USD");

    private final String value;

    Currency(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
