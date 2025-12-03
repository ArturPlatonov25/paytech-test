package pay.tech.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OrderDto {
    private OffsetDateTime timestamp;
    private int status;
    private OrderInfoDto result;
}
