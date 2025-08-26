package org.lessons.java.project_final_auto_java.repository;

import org.lessons.java.project_final_auto_java.model.Automobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomobileRepository extends JpaRepository<Automobile, Integer> {
    // public List<Automobile> findByModelloContainingIgnoreCase(String modello);
}
