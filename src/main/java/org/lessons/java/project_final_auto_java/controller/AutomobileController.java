package org.lessons.java.project_final_auto_java.controller;

import java.util.List;

import org.lessons.java.project_final_auto_java.model.Automobile;
import org.lessons.java.project_final_auto_java.repository.AutomobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/automobili")
public class AutomobileController {

    @Autowired

    private AutomobileRepository automobileRepository;

    @GetMapping

    public String index(Model model) {
        List<Automobile> automobile = automobileRepository.findAll();
        model.addAttribute("automobili", automobile);
        return "automobili/index";
    }
}
