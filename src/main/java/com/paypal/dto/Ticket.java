package com.paypal.dto;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private long eid;
    private String name;
    private String email;
    @Column(name = "phone")
    private String phoneNumber;
    private Integer quantity;
    private boolean paid;
}
