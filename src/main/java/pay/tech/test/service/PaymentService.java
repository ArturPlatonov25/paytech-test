package pay.tech.test.service;

import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pay.tech.test.client.PaymentsClient;
import pay.tech.test.dto.OrderDto;
import pay.tech.test.dto.PaymentDto;

@Service
@AllArgsConstructor
public class PaymentService {
    private final PaymentsClient paymentsClient;

    public String createOrder(PaymentDto payment, Model model) {
        try {
            OrderDto orderDto = paymentsClient.createOrder(payment);
            return "redirect:" + orderDto.getResult().getRedirectUrl();
        } catch (FeignException e) {
            model.addAttribute("status", e.status());
            return "index";
        }
    }

}
