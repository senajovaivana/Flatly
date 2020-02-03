package edu.pw.react.project.backend.dao;

import edu.pw.react.project.backend.model.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Date;

public interface BookingRepository  extends JpaRepository<BookingEntity, Long> {
    @Query("select u from BookingEntity u where u.item_id = :id order by u.start_date desc")
    Collection<BookingEntity> findAllBookingsOfFlat(@Param("id")Long id);

    @Query("select u from BookingEntity u where u.item_id = :id order by u.start_date desc")
    Collection<BookingEntity> findAllBookingsOfUser(@Param("id")Long id);

    @Query(value = " SELECT b FROM BookingEntity b where b.active = :active ")
    Collection<BookingEntity> findBookingsByActive(@Param("active") boolean active);

    @Query(value = " SELECT count(b) FROM BookingEntity b where b.item_id = :item_id and b.active = :active and b.start_date < :bookingEnd and (b.end_date is null or b.end_date > :bookingStart)")
    long checkavaibility(@Param("item_id") Long item_id, @Param("active") char active, @Param("bookingStart") Date bookingStart, @Param("bookingEnd") Date bookingEnd);
}
