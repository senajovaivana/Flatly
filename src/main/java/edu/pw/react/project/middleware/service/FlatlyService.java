package edu.pw.react.project.middleware.service;

import edu.pw.react.project.backend.model.FlatEntity;

public interface FlatlyService {
  FlatEntity updateFlat(Long FlatId, FlatEntity updatedFlat);
    boolean deleteFlat(Long FlatId);
}
