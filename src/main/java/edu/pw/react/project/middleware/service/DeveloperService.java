package edu.pw.react.project.middleware.service;

import edu.pw.react.project.backend.model.DeveloperEntity;

public interface DeveloperService {

    DeveloperEntity updateDeveloper(Long id, DeveloperEntity updatedDeveloooper);
}