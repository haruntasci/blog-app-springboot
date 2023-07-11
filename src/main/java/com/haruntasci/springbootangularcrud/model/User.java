package com.haruntasci.springbootangularcrud.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private LocalDate creationDate = LocalDate.now();
    private Boolean isActive;

}
