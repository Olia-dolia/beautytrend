package com.example.beautytrend.controller;

import com.example.beautytrend.entities.Client;
import com.example.beautytrend.repo.ProcedureRepo;
import com.example.beautytrend.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateController {
    @Autowired
    private ClientServiceImpl clientService;
    @Autowired
    private ProcedureRepo procedureRepo;

    protected String clientName;
    protected String clientTel;

    @GetMapping("/create")
    public String show() {
        return "create";
    }

    @PostMapping("/create")
    public String createClient(@RequestParam String name, @RequestParam String tel,
                               Client client, Model model){
        client.setName(name);
        client.setTel(tel);
        clientName = name;
        clientTel = tel;
        clientService.addOrUpdate(client);
        model.addAttribute("procedures", procedureRepo.findAll());
        return "main";
    }
}
