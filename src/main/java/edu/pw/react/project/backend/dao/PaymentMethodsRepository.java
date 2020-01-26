
package edu.pw.react.project.backend.dao;

import edu.pw.react.project.backend.model.PaymentMethodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodsRepository extends JpaRepository<PaymentMethodsEntity, Long> {

}

