package edu.pw.react.project.backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "payment_method")
@Data
public class PaymentMethodsFlatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    private Long id_room;
    @Column(name = "payment_method_id")
    private Long id_payment_method;
}
