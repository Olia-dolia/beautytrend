package com.example.beautytrend.controller;

import com.example.beautytrend.entities.Client;
import com.example.beautytrend.entities.CustDate;
import com.example.beautytrend.entities.Master;
import com.example.beautytrend.entities.Procedure;
import com.example.beautytrend.repo.ClientRepo;
import com.example.beautytrend.repo.CustDatesRepo;
import com.example.beautytrend.repo.MastersRepo;
import com.example.beautytrend.service.ClientServiceImpl;
import com.example.beautytrend.service.ProcedureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Time;
import java.util.List;


@Controller
@RequestMapping("/procedures")
public class ProcedureController {

    @Autowired
    private CustDatesRepo custDatesRepo;
    @Autowired
    private MastersRepo mastersRepo;
    @Autowired
    private ProcedureServiceImpl procedureServiceImpl;
    @Autowired
    private ClientServiceImpl clientService;
    @Autowired
    private ClientRepo clientRepo;
    private CreateController controller;

    public ProcedureController(CreateController controller) {
        this.controller = controller;
    }

    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable("id") Long id, ModelAndView mav, Client client
                             /*,String clientName, String clientTel*/) {

        Procedure procedure = procedureServiceImpl.findOne(id).get();
        List<Master> masters = mastersRepo.findAll();
        List<CustDate> dates = custDatesRepo.findAll();
        mav.addObject("client", clientRepo.findByNameAndTel(controller.clientName, controller.clientTel));
        mav.addObject("procedure", procedure);
        mav.addObject("masters", masters);
        mav.addObject("dates", dates);
        mav.setViewName("procedures/procedure");
        return mav;
    }

    @PostMapping("booking")
    public String booking(@RequestParam Long id,
                          @RequestParam String mastername,@RequestParam String date,
                          @RequestParam Time time){
        Master masterFromDb = mastersRepo.findByName(mastername);
        CustDate dateFromDb = custDatesRepo.findByDate(date);
        dateFromDb.setTime(time);
        Client clientFromDb = clientRepo.findByNameAndTel(controller.clientName, controller.clientTel);
        procedureServiceImpl.updateProcedure(id,masterFromDb,dateFromDb,clientFromDb);
        return "redirect:/";
    }
}
