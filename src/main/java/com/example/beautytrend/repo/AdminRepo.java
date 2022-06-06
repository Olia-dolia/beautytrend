package com.example.beautytrend.repo;

import com.example.beautytrend.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Long> {
    Admin findByLoginAndPassword(String login, String password);
}
