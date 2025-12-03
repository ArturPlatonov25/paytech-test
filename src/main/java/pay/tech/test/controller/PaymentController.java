package pay.tech.test.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pay.tech.test.dto.Currency;
import pay.tech.test.dto.PaymentDto;
import pay.tech.test.service.PaymentService;


@Controller
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {


    private final PaymentService paymentService;

    @ModelAttribute("currencies")
    public Currency[] currencies() {
        return Currency.values();
    }

    @ModelAttribute("paymentDto")
    public PaymentDto paymentDto() {
        return new PaymentDto();
    }

    @GetMapping("/create")
    public String createGet(HttpServletRequest request, Model model) {
        model.addAttribute("formAction", request.getRequestURI());
        return "index";
    }

    @PostMapping("/create")
    public String createPost(
        @Valid @ModelAttribute("paymentForm") PaymentDto payment,
        Model model
    ) {
        return paymentService.createOrder(payment, model);
    }
}
