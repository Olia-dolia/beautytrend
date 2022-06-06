package com.example.beautytrend.repo;

import com.example.beautytrend.entities.Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MastersRepo extends JpaRepository<Master, Long> {

    Master findByName(String name);
}
