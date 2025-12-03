package pay.tech.test.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pay.tech.test.config.FeignConfig;
import pay.tech.test.dto.OrderDto;
import pay.tech.test.dto.PaymentDto;

@Service
@FeignClient(name = "paymentsClient", url = "${payment.api.url}", configuration = FeignConfig.class)
public interface PaymentsClient {

    @PostMapping
    OrderDto createOrder(@RequestBody PaymentDto paymentDto);
}
