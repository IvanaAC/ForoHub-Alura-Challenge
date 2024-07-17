package com.alurachallenge.foro.hub.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Complete el título.")
    private String title;

    @NotBlank(message = "Complete el cuerpo del mensaje.")
    private String message;

    @NotBlank(message = "Complete el nombre del curso.")
    private String courseName;

    private String userEmail;
}
