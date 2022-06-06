package com.example.beautytrend.service;

import com.example.beautytrend.entities.Client;
import com.example.beautytrend.repo.ClientRepo;
import com.example.beautytrend.service.interfaces.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;

    public ClientServiceImpl(ClientRepo clientRepo){
        this.clientRepo = clientRepo;
    }

    @Override
    public Client addOrUpdate(Client client) {
        if (!clientRepo.existsByNameAndTel(client.getName(),client.getTel())){
            return clientRepo.save(client);
        }
        Client clientFromDb = clientRepo.findByNameAndTel(client.getName(),client.getTel());
        return clientFromDb;
    }
}
