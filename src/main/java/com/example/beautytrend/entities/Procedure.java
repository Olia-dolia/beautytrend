package com.example.beautytrend.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@Setter
@Getter
@Entity
public class Procedure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String tag;
    private Integer price;
    @OneToOne(cascade = CascadeType.ALL)
    private CustDate date;
    @OneToOne(fetch = FetchType.LAZY)
    private Master master;
    @OneToOne(fetch = FetchType.EAGER)
    private Client client;

    public Procedure(String title, String tag, Integer price, CustDate date,
                     Master master, Client client){
        this.title = title;
        this.tag = tag;
        this.price = price;
        this.date = date;
        this.master = master;
        this.client = client;
    }

    public Long getId() {
        return id;
    }
}
