package com.example.beautytrend.repo;

import com.example.beautytrend.entities.CustDate;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustDatesRepo extends JpaRepository<CustDate, Long> {
    CustDate findByDate(String date);
}
