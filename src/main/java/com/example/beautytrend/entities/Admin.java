package com.example.beautytrend.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @NotEmpty(message = "Login should not be empty")
    private String login;
    @NotEmpty(message = "Password should not be empty")
    private String password;

    public Admin(String login, String password){
        this.login = login;
        this.password = password;
    }
}
