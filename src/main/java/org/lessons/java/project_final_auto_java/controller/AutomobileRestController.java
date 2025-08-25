package org.lessons.java.project_final_auto_java.controller;

import java.util.List;
import java.util.Optional;

import org.lessons.java.project_final_auto_java.model.Automobile;
import org.lessons.java.project_final_auto_java.service.AutomobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("automobili/api")
public class AutomobileRestController {

    @Autowired
    private AutomobileService automobileService;

    @GetMapping
    public List<Automobile> index() {
        return automobileService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Automobile> show(@PathVariable Integer id) {
        Optional<Automobile> automobileAttempt = automobileService.getById(id);
        if (automobileAttempt.isEmpty()) {
            return new ResponseEntity<Automobile>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Automobile>(automobileAttempt.get(), HttpStatus.OK);
    }
}
