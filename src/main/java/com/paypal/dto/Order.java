package com.paypal.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Order {
    private double price;
    private String currency; // tiền tệ
    private String method;
    private String intent; // ý định
    private String description;
}
