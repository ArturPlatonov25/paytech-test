package pay.tech.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;

@Getter
@Setter
public class OrderInfoDto {
    private String id;
    private String created;
    private PaymentType paymentType;
    private String state;
    private BigDecimal amount;
    private Currency currency;
    private String redirectUrl;
    private String shopName;
    private Map<String, Object> externalRefs;
}
