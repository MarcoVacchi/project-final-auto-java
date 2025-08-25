package org.lessons.java.project_final_auto_java.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.project_final_auto_java.model.Recensione;
import org.lessons.java.project_final_auto_java.repository.RecensioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecensioneService {

    @Autowired
    private RecensioneRepository recensioneRepository;

    public List<Recensione> findAll() {
        return recensioneRepository.findAll();
    }

    public Recensione findById(Integer id) {

        return recensioneRepository.findById(id).get();
    }

    public Optional<Recensione> getById(Integer id) {
        return recensioneRepository.findById(id);
    }

    public Recensione create(Recensione recensione) {
        return recensioneRepository.save(recensione);
    }

    public Recensione update(Recensione recensione) {
        return recensioneRepository.save(recensione);
    }

    public void deleteById(Integer id) {
        recensioneRepository.deleteById(id);
    }

}
