package edu.pw.react.project.backend.dao;

import edu.pw.react.project.backend.model.BookingEntity;
import edu.pw.react.project.backend.model.FlatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface FlatRepository extends JpaRepository<FlatEntity, Long>, JpaSpecificationExecutor<FlatEntity> {
    @Transactional
    @Modifying
    @Query("update FlatEntity u set u.active = 'F' where u.id = :id")
    int updateFlatToNonActive(@Param("id") Long id) ;

    @Query("select u from FlatEntity u where u.owner_of_room = :idUser and u.active='T' order by u.name_of_room")
    Collection<FlatEntity> findAllActiveFlats(Long idUser);

    @Query("select u from FlatEntity u where u.owner_of_room = :idUser and u.active='F' order by u.name_of_room")
    Collection<FlatEntity> findAllNonactiveFlats(Long idUser);

    @Query("select u.room_bookings from FlatEntity u where u.owner_of_room = :idUser")
    Collection<BookingEntity> findAllReservations(Long idUser);

    @Query("select u from FlatEntity u where u.active = :active")
    Collection<FlatEntity> findAllFlatsByParam(char active);
}
