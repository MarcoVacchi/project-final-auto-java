package org.lessons.java.project_final_auto_java.service;

import java.util.List;

import org.lessons.java.project_final_auto_java.model.OptionalAuto;
import org.lessons.java.project_final_auto_java.model.Recensione;
import org.lessons.java.project_final_auto_java.repository.OptionalAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionalAutoService {
    @Autowired
    private OptionalAutoRepository optionalAutoRepository;

    public List<OptionalAuto> findAll() {
        return optionalAutoRepository.findAll();
    }

    public OptionalAuto findById(Integer id) {
        return optionalAutoRepository.findById(id).get();
    }

    public OptionalAuto create(OptionalAuto optionalAuto) {
        return optionalAutoRepository.save(optionalAuto);
    }

    public OptionalAuto update(OptionalAuto optionalAuto) {
        return optionalAutoRepository.save(optionalAuto);
    }

    public void deleteById(Integer id) {
        optionalAutoRepository.deleteById(id);
    }
}
