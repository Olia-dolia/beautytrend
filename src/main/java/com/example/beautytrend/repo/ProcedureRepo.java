package com.example.beautytrend.repo;

import com.example.beautytrend.entities.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcedureRepo extends JpaRepository<Procedure, Long> {
    List<Procedure> findByTag(String tag);
}
