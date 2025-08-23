package org.lessons.java.project_final_auto_java.controller;

import java.util.List;

import org.lessons.java.project_final_auto_java.model.Automobile;
import org.lessons.java.project_final_auto_java.repository.AutomobileRepository;
import org.lessons.java.project_final_auto_java.service.AutomobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/automobili")
public class AutomobileController {

    @Autowired

    private AutomobileService automobileService;

    @GetMapping
    public String index(Model model) {
        List<Automobile> automobile = automobileService.findAll();
        model.addAttribute("automobili", automobile);
        return "automobili/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {

        Automobile automobile = automobileService.findById(id).get();
        model.addAttribute("automobile", automobile);
        return "automobili/show";
    }
}