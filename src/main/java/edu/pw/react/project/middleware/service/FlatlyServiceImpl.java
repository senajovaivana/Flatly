package edu.pw.react.project.middleware.service;

import edu.pw.react.project.backend.dao.FlatRepository;
import edu.pw.react.project.backend.model.FlatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class FlatlyServiceImpl implements FlatlyService {

    private final Logger logger = LoggerFactory.getLogger(FlatlyServiceImpl.class);

    private FlatRepository repository;

    FlatlyServiceImpl() { }

    @Autowired
    FlatlyServiceImpl(FlatRepository repository) {
        this.repository = repository;
    }

    @Override
    public FlatEntity updateFlat(Long id, FlatEntity updatedFlat) {
        FlatEntity result = FlatEntity.EMPTY;
        if (repository.existsById(id)) {
            updatedFlat.setId(id);
            result = repository.save(updatedFlat);
            logger.info("Flat with id {} updated.", id);
        }
        return result;
    }

    @Override
    public boolean deleteFlat(Long id) {
        boolean result = false;
        if (repository.existsById(id)) {
            repository.deleteById(id);
            logger.info("Flat with id {} deleted.", id);
            result = true;
        }
        return result;
    }
}
