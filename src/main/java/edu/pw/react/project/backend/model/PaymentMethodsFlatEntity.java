package edu.pw.react.project.backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "payment_method_of_room", schema = "public")
@Data
public class PaymentMethodsFlatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    private Long room_id;
    @Column(name = "payment_method_id")
    private Long payment_method_id;
}
