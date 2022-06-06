package com.example.beautytrend.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class CustDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private Time time;

    public CustDate(String date, Time time, Boolean isBooking){
        this.date = date;
        this.time = time;
    }
}
