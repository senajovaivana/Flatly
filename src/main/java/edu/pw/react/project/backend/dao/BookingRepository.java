package edu.pw.react.project.backend.dao;

import edu.pw.react.project.backend.model.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    @Query(value = " SELECT b FROM BookingEntity b where b.active = :active ")
    Collection<BookingEntity> findBookingsByActive(@Param("active") boolean active);
}
