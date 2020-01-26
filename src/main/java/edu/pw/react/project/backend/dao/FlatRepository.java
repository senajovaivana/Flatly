package edu.pw.react.project.backend.dao;

import edu.pw.react.project.backend.model.FlatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public interface FlatRepository extends JpaRepository<FlatEntity, Long>, JpaSpecificationExecutor<FlatEntity> {
    @Transactional
    @Modifying
    @Query("update FlatEntity u set u.active = 'F' where u.id = :id")
    int updateFlatToNonActive(@Param("id") Long id) ;

    @Query("SELECT f FROM FlatEntity f where f.active = 'T' ")
    Collection<FlatEntity> findAllActiveFlats();
}
