package edu.pw.react.project.restapi.controller;

import edu.pw.react.project.backend.dao.BookingRepository;
import edu.pw.react.project.backend.model.BookingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/bookings")
public class BookingController {
    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "")
    public ResponseEntity<Collection<BookingEntity>> getAllFlats() {
        System.out.println("Getting All bookings");
        return ResponseEntity.ok(bookingRepository.findAll());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/flat/{id}")
    public ResponseEntity<Collection<BookingEntity>> getBookingsByIdOfFlat(@PathVariable Long id) {
        System.out.println("Getting bookings of flat");
        return ResponseEntity.ok(bookingRepository.findAllBookingsOfFlat(id));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/{id}")
    public ResponseEntity<BookingEntity> getBookingById(@PathVariable Long id) {
        System.out.println("Getting booking");
        BookingEntity f = bookingRepository.findById(id).orElseGet(BookingEntity::new);
        return new ResponseEntity<>(f, HttpStatus.OK);
    }
}
