package org.lessons.java.project_final_auto_java.controller;

import org.lessons.java.project_final_auto_java.model.Recensione;
import org.lessons.java.project_final_auto_java.service.RecensioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import jakarta.validation.Valid;

@Controller
@RequestMapping("recensioni")
public class RecensioneController {
    @Autowired
    private RecensioneService recensioneService;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("recensione") Recensione formRecensione, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "recensioni/create";
        }
        recensioneService.create(formRecensione);
        return "redirect:/automobili";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("recensione", recensioneService.findById(id));
        return "recensioni/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("sale") Recensione formRecensione, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "recensioni/edit";
        }
        recensioneService.update(formRecensione);
        return "redirect:/automobili/" + formRecensione.getAutomobile().getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        recensioneService.deleteById(id);
        return "redirect:/automobili";
    }
}
