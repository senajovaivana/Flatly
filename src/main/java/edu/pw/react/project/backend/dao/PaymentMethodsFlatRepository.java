package edu.pw.react.project.backend.dao;

import edu.pw.react.project.backend.model.PaymentMethodsFlatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodsFlatRepository extends JpaRepository<PaymentMethodsFlatEntity, Long> {

}
