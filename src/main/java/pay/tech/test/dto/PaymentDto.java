package pay.tech.test.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentDto {
    @NotNull
    @DecimalMin(value = "0.01")
    @Digits(integer = 15, fraction = 2)
    private BigDecimal amount;

    @NotNull
    private Currency currency;
    private PaymentType paymentType = PaymentType.DEPOSIT;
}
