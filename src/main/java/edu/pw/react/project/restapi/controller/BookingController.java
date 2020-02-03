package edu.pw.react.project.restapi.controller;

import edu.pw.react.project.backend.dao.BookingRepository;
import edu.pw.react.project.backend.dao.FlatRepository;
import edu.pw.react.project.backend.model.BookingEntity;
import edu.pw.react.project.backend.model.FlatEntity;
import edu.pw.react.project.middleware.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping(path = "/bookings")
public class BookingController {
    private BookingRepository bookingRepository;
    private FlatRepository flatRepository;

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingRepository bookingRepository, FlatRepository flatRepository, BookingService bookingService) {
        this.bookingRepository = bookingRepository;
        this.flatRepository = flatRepository;
        this.bookingService = bookingService;
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

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "")
    @Transactional
    public ResponseEntity<BookingEntity> createBooking(@Valid @RequestBody BookingEntity booking) {
        System.out.println("Creating booking");
        //check if can be reserved
        //FIXME
        bookingRepository.save(booking);

        return new ResponseEntity<>(bookingRepository.save(booking), HttpStatus.OK);
    }
}
