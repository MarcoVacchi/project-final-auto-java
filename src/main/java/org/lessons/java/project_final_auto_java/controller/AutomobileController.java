package org.lessons.java.project_final_auto_java.controller;

import java.util.List;

import org.lessons.java.project_final_auto_java.model.Automobile;
import org.lessons.java.project_final_auto_java.model.Recensione;
import org.lessons.java.project_final_auto_java.service.AutomobileService;
import org.lessons.java.project_final_auto_java.service.OptionalAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/automobili")
public class AutomobileController {

    @Autowired

    private AutomobileService automobileService;

    @Autowired
    private OptionalAutoService optionalAutoService;

    // index
    @GetMapping
    public String index(Model model) {
        List<Automobile> automobile = automobileService.findAll();
        model.addAttribute("automobili", automobile);
        return "automobili/index";
    }

    // show
    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {

        Automobile automobile = automobileService.getById(id).get();
        model.addAttribute("automobile", automobile);
        model.addAttribute("recensioni", automobile.getRecensioni());
        return "automobili/show";
    }

    // ricerca
    @GetMapping("/searchByModel")
    public String searchByModel(@RequestParam(name = "modello") String modello,
            Model model) {
        List<Automobile> automobile = automobileService.findByModelloContaining(modello);
        model.addAttribute("automobili", automobile);
        model.addAttribute("name", modello);
        return "automobili/index";
    }

    // creazione nuova auto + optional
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("automobile", new Automobile());
        model.addAttribute("optional", optionalAutoService.findAll());
        return "automobili/create";
    }

    // creazione nuova auto + optional
    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("automobile") Automobile formAutomobile, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "automobili/create";
        }
        automobileService.create(formAutomobile);
        return "redirect:/automobili";
    }

    // modifica
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("automobile", automobileService.getById(id).get());
        model.addAttribute("optional", optionalAutoService.findAll());
        return "automobili/edit";
    }

    // modifica
    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("automobile") Automobile formAutomobile, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("optionals", optionalAutoService.findAll());
            return "automobili/edit";

        }
        automobileService.update(formAutomobile);
        return "redirect:/automobili";
    }

    // eliminazione
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        automobileService.deleteById(id);
        return "redirect:/automobili";
    }

    // recensioni oneToMany
    @GetMapping("/{id}/recensioni")
    public String recensione(@PathVariable("id") Integer id, Model model) {
        Recensione recensione = new Recensione();
        recensione.setAutomobile(automobileService.getById(id).get());
        model.addAttribute("recensione", recensione);
        return "recensioni/create";
    }
}