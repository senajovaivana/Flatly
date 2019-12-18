package edu.pw.react.project.backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "room")
@Data
public class PaymentMethodsFlatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_room")
    private Long id_room;
    @Column(name = "id_payment_method")
    private Long id_payment_method;
}
