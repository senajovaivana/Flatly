package edu.pw.react.project.middleware.service;

import edu.pw.react.project.backend.model.BookingEntity;

public interface BookingService {
    BookingEntity updateBooking(Long id, BookingEntity updatedBooking) ;

    boolean deleteBooking(Long id);

    BookingEntity checkavaibility(BookingEntity savedbooking);
}
