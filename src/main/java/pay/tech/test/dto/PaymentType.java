package pay.tech.test.dto;


import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentType {
    DEPOSIT("DEPOSIT");

    private final String value;

    PaymentType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
