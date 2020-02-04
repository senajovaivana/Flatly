package edu.pw.react.project.backend.dao;

import edu.pw.react.project.backend.model.FlatEntity;
import edu.pw.react.project.backend.model.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

    @Transactional
    @Modifying
    @Query("delete from ImageEntity u where u.room_id = :id")
    void deleteImageOfRoom(@Param("id") Long id) ;
}
