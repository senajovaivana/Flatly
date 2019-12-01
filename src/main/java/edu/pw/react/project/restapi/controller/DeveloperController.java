package edu.pw.react.project.restapi.controller;


import edu.pw.react.project.backend.dao.DeveloperRepository;
import edu.pw.react.project.backend.model.DeveloperEntity;
import edu.pw.react.project.middleware.service.DeveloperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/developer")
public class DeveloperController {

    private final Logger logger = LoggerFactory.getLogger(DeveloperController.class);

    private DeveloperRepository developerRepository;
    private DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperRepository developerRepository, DeveloperService developerService) {
        this.developerRepository = developerRepository;
        this.developerService = developerService;
    }

    @GetMapping(path = "")
    public ResponseEntity<Collection<DeveloperEntity>> getAllDevelopers() {
        System.out.println("Getting All Developers");
        return ResponseEntity.ok(developerRepository.findAll());
    }
}

