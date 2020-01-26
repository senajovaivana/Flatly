package edu.pw.react.project.backend.dao;

import edu.pw.react.project.backend.model.FlatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface FlatRepository extends JpaRepository<FlatEntity, Long> {
    @Transactional
    @Modifying
    @Query("update FlatEntity u set u.active = 'F' where u.id = :id")
    int updateFlatToNonActive(@Param("id") Long id) ;

    @Query("select u from FlatEntity u where u.active = 'T'")
    Collection<FlatEntity> findAllActiveFlats();

    @Query("select u from FlatEntity u where u.active = :active")
    Collection<FlatEntity> findAllFlatsByParam(char active);
}
