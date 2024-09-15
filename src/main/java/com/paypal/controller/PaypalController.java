package com.paypal.controller;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.paypal.dto.Order;
import com.paypal.service.EventRepository;
import com.paypal.service.PaypalService;
import com.paypal.service.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
@Controller
public class PaypalController {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    PaypalService paypalService;

    public static final String SUCCESS_URL = "success";
    public static final String CANCEL_URL = "cancel";


    @GetMapping("/pay/{id}")
    public String home(@PathVariable("id") String id) {
        var order = ticketRepository.findById(Long.parseLong(id)).map(t->Order.builder()
                .currency("USD")
                .price(eventRepository.getReferenceById(t.getEid()).getPrice().multiply(BigDecimal.valueOf(t.getQuantity())).doubleValue())
                .method("PAYPAL")
                .intent("sale")
                .description("")
                .build()).orElseThrow();
        try {
            Payment payment = paypalService.createPayment(
                    order.getPrice(),
                    order.getCurrency(),
                    order.getMethod(),
                    order.getIntent(),
                    order.getDescription(),
                    "http://localhost:8080/" + CANCEL_URL+"?id="+id,
                    "http://localhost:8080/" + SUCCESS_URL+"?id="+id
            );

            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return "redirect:" + link.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
            ticketRepository.deleteById(Long.parseLong(id));
        }
        return "redirect:/";
    }

//
    @GetMapping(value = CANCEL_URL)
    public String cancelView(@RequestParam("id") String id) {
        ticketRepository.deleteById(Long.parseLong(id));
        System.out.println(id);
        return "cancelView.html";}

    @GetMapping(value = SUCCESS_URL)
    public String successPay(
            @RequestParam("paymentId") String paymentId,
            @RequestParam("PayerID") String PayerId,
            @RequestParam("id") String id
    ) {
        try {
            Payment payment = paypalService.executePayment(paymentId, PayerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return "success";
            }
        } catch (PayPalRESTException e) {
            ticketRepository.deleteById(Long.parseLong(id));
            System.out.println(e.getMessage());
        }

        return "redirect:/";
    }
}
