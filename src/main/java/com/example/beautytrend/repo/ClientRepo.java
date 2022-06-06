package com.example.beautytrend.repo;

import com.example.beautytrend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
    Client findByTel(String tel);
    Client findByNameAndTel(String name, String tel);

    Boolean existsByNameAndTel(String name, String tel);
}
