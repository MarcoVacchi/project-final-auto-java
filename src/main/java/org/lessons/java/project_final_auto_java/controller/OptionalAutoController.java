package org.lessons.java.project_final_auto_java.controller;

import org.lessons.java.project_final_auto_java.model.OptionalAuto;
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

import jakarta.validation.Valid;

@Controller
@RequestMapping("optionals")
public class OptionalAutoController {
    @Autowired
    private OptionalAutoService optionalAutoService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("optionals", optionalAutoService.findAll());
        return "optionals/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("optional", optionalAutoService.findById(id));
        return "optionals/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("optional", new OptionalAuto());
        return "optionals/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("optional") OptionalAuto formOptionalAuto, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "optionals/create";
        }
        optionalAutoService.create(formOptionalAuto);
        return "redirect:/optionals";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("optional", optionalAutoService.findById(id));
        model.addAttribute("optional", optionalAutoService.findAll());
        return "optionals/edit";
    }

    @PostMapping("edit/{id}")
    public String update(@Valid @ModelAttribute("optional") OptionalAuto formOptionalAuto, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {

            return "optionals/edit";
        }
        optionalAutoService.update(formOptionalAuto);
        return "redirect:/optionals";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        optionalAutoService.deleteById(id);
        return "redirect:/optionals";
    }
}
