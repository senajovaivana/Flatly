package edu.pw.react.project.middleware.service;

import edu.pw.react.project.backend.model.FlatEntity;

import java.util.Date;

public interface FlatlyService {
    FlatEntity updateFlat(Long FlatId, FlatEntity updatedFlat);
    boolean deleteFlat(Long FlatId);

    boolean isFlatBookable(Long FlatId, Date start, Date end);
}
