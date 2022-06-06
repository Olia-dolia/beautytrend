package com.example.beautytrend.controller;

import com.example.beautytrend.repo.ProcedureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainPageController {

    @Autowired
    private ProcedureRepo procedureRepo;

    @GetMapping("/main")
    public String showProcedures(Model model){
        model.addAttribute("procedures", procedureRepo.findAll());
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Model model){
        if(filter != null){
            model.addAttribute("procedures", procedureRepo.findByTag(filter));
        }
        return "main";
    }

    @GetMapping("filter")
    public String goBack(Model model){
        model.addAttribute("procedures", procedureRepo.findAll());
        return "main";
    }
}
