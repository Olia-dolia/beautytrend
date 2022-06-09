package com.example.beautytrend.controller;

import com.example.beautytrend.entities.Master;
import com.example.beautytrend.entities.Procedure;
import com.example.beautytrend.repo.MastersRepo;
import com.example.beautytrend.repo.ProcedureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdminController {
    @Autowired
    private CreateController controller;
    @Autowired
    private MastersRepo mastersRepo;
    @Autowired
    private ProcedureRepo procedureRepo;

    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }

    @GetMapping("/newmaster")
    public String addMasterPage(){
        return "newmaster";
    }

    @GetMapping("/newprocedure")
    public String addProcedurePage(){
        return "newprocedure";
    }

    @PostMapping("/newmaster")
    public String addMaster(Master master){
        mastersRepo.save(master);
        return "redirect:/";
    }

    @PostMapping("/newprocedure")
    public String addProcedure(Procedure procedure){
        procedureRepo.save(procedure);
        return "redirect:/";
    }
}
