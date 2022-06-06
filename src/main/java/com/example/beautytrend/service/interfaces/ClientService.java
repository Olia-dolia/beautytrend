package com.example.beautytrend.service.interfaces;

import com.example.beautytrend.entities.Client;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    Client addOrUpdate(Client client);
}
