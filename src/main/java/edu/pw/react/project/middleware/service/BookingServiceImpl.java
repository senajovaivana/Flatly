package edu.pw.react.project.middleware.service;

import edu.pw.react.project.backend.dao.BookingRepository;
import edu.pw.react.project.backend.model.BookingEntity;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class BookingServiceImpl implements BookingService {


    private final Logger logger = (Logger) LoggerFactory.getLogger(BookingServiceImpl.class);
        private BookingRepository repository;

        BookingServiceImpl() { }

        @Autowired
        BookingServiceImpl(BookingRepository repository) {
            this.repository = repository;
        }

        @Override
        public BookingEntity updateBooking(Long id, BookingEntity updatedBooking) {
            BookingEntity result = BookingEntity.EMPTY;
            if (repository.existsById(id)) {
                updatedBooking.setId(id);
                result = repository.save(updatedBooking);
               logger.info("Booking  is updated.", id);
            }
            return result;
        }

        @Override
        public boolean deleteBooking(Long id) {
            boolean result = false;
            if (repository.existsById(id)) {
                repository.deleteById(id);
               logger.info("Booking  id {}  is deleted.", id);
                result = true;
            }
            return result;
        }

    }
