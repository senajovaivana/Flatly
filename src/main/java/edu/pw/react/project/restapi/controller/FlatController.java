package edu.pw.react.project.restapi.controller;

import edu.pw.react.project.backend.dao.FlatRepository;
import edu.pw.react.project.backend.model.FlatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping(path = "/flats")
public class FlatController {
    private FlatRepository flatRepository;

    @Autowired
    public FlatController(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "")
    public ResponseEntity<Collection<FlatEntity>> getAllFlats(@RequestParam Long id) {
        System.out.println("Getting All flats");
        return ResponseEntity.ok(flatRepository.findAllFlats(id));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/{id}")
    public ResponseEntity<FlatEntity> getFlatById(@PathVariable Long id) {
        System.out.println("Getting flat");
        FlatEntity f = flatRepository.findById(id).orElseGet(FlatEntity::new);
        return new ResponseEntity<>(f, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "delete/{id}")
    public ResponseEntity<String> setRoomNonactive(@PathVariable Long id) throws ResourceNotFoundException {
        if (!flatRepository.existsById(id))
            return new ResponseEntity<>("Flat with id " + id + " does not exist", HttpStatus.NOT_FOUND);
        flatRepository.updateFlatToNonActive(id);

        return new ResponseEntity<>("Flat was set to nonactive", HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "")
    @Transactional
    public ResponseEntity<FlatEntity> createFlat(@Valid @RequestBody FlatEntity flat) {
        return new ResponseEntity<>(flatRepository.save(flat), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/{id}")
    public ResponseEntity<FlatEntity> updateFlat(@RequestBody FlatEntity flat) {
        long id = flat.getId();
        if (!flatRepository.existsById(id))
            throw new ResourceNotFoundException(
                    "There is no flat with this id: " + flat.getId());
        return new ResponseEntity<>(flatRepository.saveAndFlush(flatRepository.save(flat)), HttpStatus.OK);
    }
}
