package org.lessons.java.project_final_auto_java.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.project_final_auto_java.model.Automobile;
import org.lessons.java.project_final_auto_java.repository.AutomobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutomobileService {
    @Autowired
    private AutomobileRepository automobileRepository;

    public List<Automobile> findAll() {
        return automobileRepository.findAll();
    }

    public Optional<Automobile> findById(Integer id) {
        return automobileRepository.findById(id);
    }
}
