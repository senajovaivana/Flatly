package edu.pw.react.project.backend.dao;

import edu.pw.react.project.backend.model.FlatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRepository extends JpaRepository<FlatEntity, Long> {
}
