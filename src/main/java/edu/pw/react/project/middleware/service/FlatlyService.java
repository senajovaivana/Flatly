package edu.pw.react.project.middleware.service;

import edu.pw.react.project.backend.model.FlatEntity;

import java.util.Date;

public interface FlatlyService {
    FlatEntity updateFlat(Long FlatId, FlatEntity updatedFlat);

    boolean checkForDeletionAndDelete(Long id, FlatEntity flatEntity);

    boolean isFlatBookable(Long FlatId, Date start, Date end);
}
