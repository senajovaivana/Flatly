package edu.pw.react.project.backend.dao;

import edu.pw.react.project.backend.model.FlatEntity;
import edu.pw.react.project.backend.model.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

}
