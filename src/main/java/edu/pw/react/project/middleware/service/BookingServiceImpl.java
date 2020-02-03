package edu.pw.react.project.middleware.service;


import edu.pw.react.project.backend.dao.BookingRepository;
import edu.pw.react.project.backend.model.BookingEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {


    private final Logger logger = (Logger) LoggerFactory.getLogger(BookingServiceImpl.class);
    private BookingRepository repository;
    private FlatlyService flatlyService;

    BookingServiceImpl() {
    }

    @Autowired
    BookingServiceImpl(BookingRepository bookingRepository, FlatlyService flatlyService) {
        this.repository = bookingRepository;
        this.flatlyService = flatlyService;
    }

    @Override
    public BookingEntity updateBooking(Long id, BookingEntity updatedBooking) {
        BookingEntity result = BookingEntity.EMPTY;
        if (repository.existsById(id)) {
            updatedBooking.setId(id);
            result = repository.save(updatedBooking);
            logger.info("Booking  id {} is updated.", id);
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

    @Override
    public BookingEntity checkavaibility(BookingEntity bookingToSave) {
        if (!flatlyService.isFlatBookable(bookingToSave.getItem_id(), bookingToSave.getStart_date(), bookingToSave.getEnd_date())) {
            bookingToSave.setActive('F');
            return bookingToSave;
        }
        BookingEntity saved = repository.save(bookingToSave);
        long result = repository.checkavaibility(saved.getItem_id(), saved.getActive(), saved.getStart_date(), saved.getEnd_date());
        if (result > 1) {
            saved.setActive('F');
            return repository.save(saved);
        } else {
            return saved;
        }
    }

    @Override
    public boolean checkIncommingBookingForCreate(BookingEntity booking) {
        if (null != booking.getId() || //this is create, id needs to be null
                null == booking.getStart_date() || //its in validation, rechecking
                (null != booking.getEnd_date() && booking.getStart_date().after(booking.getEnd_date()))
        ) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkForDeletionAndDelete(Long id, BookingEntity booking) {
        if (null != id && id.equals(booking.getId()) && repository.existsById(id)) {
            BookingEntity fromDB = repository.findById(id).get();
            //if (fromDB.equals(booking)) {  //FIXME - problem with time zone and date
                fromDB.setActive('F');
                repository.save(fromDB);
                return true;
            //}
        }
        return false;
    }

}
