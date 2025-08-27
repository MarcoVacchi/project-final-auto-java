package org.lessons.java.project_final_auto_java.controller;

import java.util.List;
import java.util.Optional;

import org.lessons.java.project_final_auto_java.model.Automobile;
import org.lessons.java.project_final_auto_java.service.AutomobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

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
    public ResponseEntity<Automobile> show(@Valid @PathVariable Integer id) {
        Optional<Automobile> automobileAttempt = automobileService.getById(id);
        if (automobileAttempt.isEmpty()) {
            return new ResponseEntity<Automobile>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Automobile>(automobileAttempt.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Automobile> store(@Valid @RequestBody Automobile automobile) {
        return new ResponseEntity<Automobile>(automobileService.create(automobile), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Automobile> update(@Valid @RequestBody Automobile automobile, @PathVariable Integer id) {
        Optional<Automobile> automobileAttempt = automobileService.getById(id);
        if (automobileAttempt.isEmpty()) {
            return new ResponseEntity<Automobile>(HttpStatus.NOT_FOUND);
        }
        automobile.setId(id);
        return new ResponseEntity<Automobile>(automobileService.update(automobile), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Automobile> delete(@PathVariable Integer id) {
        Optional<Automobile> automobileToRemove = automobileService.getById(id);
        if (automobileToRemove.isEmpty()) {
            return new ResponseEntity<Automobile>(HttpStatus.NOT_FOUND);
        }
        automobileService.deleteById(id);
        return new ResponseEntity<Automobile>(HttpStatus.OK);
    }
}
