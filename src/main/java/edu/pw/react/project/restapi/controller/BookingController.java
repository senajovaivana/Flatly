package edu.pw.react.project.restapi.controller;

import edu.pw.react.project.backend.dao.BookingRepository;
import edu.pw.react.project.backend.dao.FlatRepository;
import edu.pw.react.project.backend.model.BookingEntity;
import edu.pw.react.project.backend.model.FlatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/bookings")
public class BookingController {
    private BookingRepository bookingRepository;
    private FlatRepository flatRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository, FlatRepository flatRepository) {
        this.bookingRepository = bookingRepository;
        this.flatRepository = flatRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "")
    public ResponseEntity<Collection<BookingEntity>> getAllBookingsOfUser(@RequestParam Long id) {
        System.out.println("Getting All bookings");
        return ResponseEntity.ok(flatRepository.findAllReservations(id));
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
