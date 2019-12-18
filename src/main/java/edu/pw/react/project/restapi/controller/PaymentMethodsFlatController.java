package edu.pw.react.project.restapi.controller;

import edu.pw.react.project.backend.dao.PaymentMethodsFlatRepository;
import edu.pw.react.project.backend.dao.UserRepository;
import edu.pw.react.project.backend.model.PaymentMethodsFlatEntity;
import edu.pw.react.project.backend.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/payment/")
public class PaymentMethodsFlatController {
    private PaymentMethodsFlatRepository methodsFlatRepository;
    @Autowired
    public PaymentMethodsFlatController(PaymentMethodsFlatRepository repository) {
        this.methodsFlatRepository = repository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/{idOfFlat}")
    public ResponseEntity<PaymentMethodsFlatEntity> getMethodsOfFlat(@PathVariable Long id) {
       // UserEntity u = repository.findById(id).orElseGet(UserEntity::new);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
