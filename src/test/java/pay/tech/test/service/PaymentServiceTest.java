package pay.tech.test.service;

import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import pay.tech.test.client.PaymentsClient;
import pay.tech.test.dto.OrderDto;
import pay.tech.test.dto.OrderInfoDto;
import pay.tech.test.dto.PaymentDto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    @Mock
    private PaymentsClient paymentsClient;

    @InjectMocks
    private PaymentService paymentService;


    @Test
    void testCreateOrder_success() {
        PaymentDto payment = new PaymentDto();
        OrderDto orderDto = new OrderDto();
        OrderInfoDto result = new OrderInfoDto();
        result.setRedirectUrl("https://example.com/pay");
        orderDto.setResult(result);

        when(paymentsClient.createOrder(payment)).thenReturn(orderDto);

        Model model = new ConcurrentModel();
        String url = paymentService.createOrder(payment, model);

        assertEquals("redirect:https://example.com/pay", url);
    }

    @Test
    void testCreateOrder_feignException() {
        PaymentDto payment = new PaymentDto();

        when(paymentsClient.createOrder(payment)).thenThrow(mock(FeignException.class));
        Model model = new ConcurrentModel();

        String view = paymentService.createOrder(payment, model);

        assertEquals("index", view);
        assertNotNull(model.getAttribute("status"));
    }
}