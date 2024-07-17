package com.alurachallenge.foro.hub.domain.usuario;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private String password;

    public Usuario(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
