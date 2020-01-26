package edu.pw.react.project.backend.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "payment_method", schema = "public")
@Data
public class PaymentMethodsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_method_id")
    private Long id;
    @Column(name = "name_of_method")
    @Size(min = 1, max = 40)
    private String name_of_method;
}