package com.example.beautytrend.service.interfaces;

import com.example.beautytrend.entities.Client;
import com.example.beautytrend.entities.CustDate;
import com.example.beautytrend.entities.Master;
import com.example.beautytrend.entities.Procedure;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProcedureService {
    Optional<Procedure> findOne(Long id);

    Procedure updateProcedure(Long id, Master master, CustDate date, Client client);
}
