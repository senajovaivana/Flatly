package edu.pw.react.project.middleware.service;

import edu.pw.react.project.backend.dao.FlatRepository;
import edu.pw.react.project.backend.model.BookingEntity;
import edu.pw.react.project.backend.model.FlatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

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
    public boolean checkForDeletionAndDelete(Long id, FlatEntity flatEntity) {
        if (null != id && id.equals(flatEntity.getId()) &&repository.existsById(id)) {
            FlatEntity fromDB = repository.findById(id).get();
            //if (fromDB.equals(flatEntity)) {  //FIXME - problem with time zone and date
                fromDB.setActive('F');
                repository.save(fromDB);
                logger.info("Flat with id {} deleted.", id);
                return true;
            //}
        }
        return false;
    }

    @Override
    public boolean isFlatBookable(Long flatId, Date start, Date end) {
        if (repository.existsById(flatId)) {
            FlatEntity flat = repository.findById(flatId).get();
            if ('T' == flat.getActive() &&
                    flat.getStart_date().before(start) &&
                    (null == flat.getEnd_date() || flat.getEnd_date().after(end))) {
                return true;
            }
        }
        return false;
    }
}
