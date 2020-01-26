package edu.pw.react.project.middleware.service;

import edu.pw.react.project.backend.dao.DeveloperRepository;
import edu.pw.react.project.backend.model.DeveloperEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeveloperServiceImpl implements DeveloperService {
    private final Logger logger = LoggerFactory.getLogger(DeveloperServiceImpl.class);

    private DeveloperRepository repository;

    DeveloperServiceImpl() {}

    @Autowired
    DeveloperServiceImpl(DeveloperRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeveloperEntity updateDeveloper(Long id, DeveloperEntity updatedDeveloper) {
        if (repository.existsById(id)) {
            updatedDeveloper.setId(id);
            DeveloperEntity result = repository.save(updatedDeveloper);
            logger.info("Developer with id {} updated.", id);
            return result;
        }
        return DeveloperEntity.EMPTY;
    }
}
