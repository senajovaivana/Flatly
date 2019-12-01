package edu.pw.react.project.backend.dao;

import edu.pw.react.project.backend.model.DeveloperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<DeveloperEntity, Long> {
}
