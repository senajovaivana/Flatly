package edu.pw.react.project.restapi.controller;

import edu.pw.react.project.backend.dao.FlatRepository;
import edu.pw.react.project.backend.model.FlatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
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
    public ResponseEntity<Collection<FlatEntity>> getAllFlats() {
        System.out.println("Getting All flats");
        return ResponseEntity.ok(flatRepository.findAll());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/{id}")
    public ResponseEntity<FlatEntity> getFlatById( @PathVariable Long id) {
        System.out.println("Getting flat");
        FlatEntity f = flatRepository.findById(id).orElseGet(FlatEntity::new);
        return new ResponseEntity<>(f, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundException {
        if (!flatRepository.existsById(id))
            return new ResponseEntity<>("Flat with id " + id + " does not exist", HttpStatus.NOT_FOUND);
        flatRepository.deleteById(id);
        return new ResponseEntity<>("Flat was deleted", HttpStatus.OK);
    }

    @PostMapping(value = "")
    public void createUser(@Valid @RequestBody FlatEntity flat) throws IOException {
        if (flatRepository.existsById(flat.getId())) {
            throw new ResourceNotFoundException(
                    "There is already an flat with this id: " + flat.getId());
        }
        new ResponseEntity<>(flatRepository.save(flat), HttpStatus.OK);
    }
}
