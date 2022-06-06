package com.example.beautytrend.service;

import com.example.beautytrend.entities.Client;
import com.example.beautytrend.entities.CustDate;
import com.example.beautytrend.entities.Master;
import com.example.beautytrend.entities.Procedure;
import com.example.beautytrend.repo.*;
import com.example.beautytrend.service.interfaces.ProcedureService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProcedureServiceImpl implements ProcedureService {
    private final ProcedureRepo procedureRepo;
    private final MastersRepo mastersRepo;
    private final CustDatesRepo custDatesRepo;
    private final ClientRepo clientRepo;
    public ProcedureServiceImpl(ProcedureRepo procedureRepo, MastersRepo mastersRepo,
                                CustDatesRepo custDatesRepo, ClientRepo clientRepo){
        this.procedureRepo = procedureRepo;
        this.mastersRepo = mastersRepo;
        this.custDatesRepo = custDatesRepo;
        this.clientRepo = clientRepo;
    }

    @Override
    public Optional<Procedure> findOne(Long id){
        return procedureRepo.findById(id);
    }

    @Override
    public Procedure updateProcedure(Long id, Master master, CustDate date, Client client) {
        Optional<Procedure> procedureFromDb =  procedureRepo.findById(id);
        Procedure p = procedureFromDb.get();
        p.setMaster(mastersRepo.findByName(master.getName()));
        p.setDate(custDatesRepo.findByDate(date.getDate()));
        p.setClient(clientRepo.findByNameAndTel(client.getName(), client.getTel()));
        return null;
    }
}
