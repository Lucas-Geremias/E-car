package com.ecar.domain;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;
}
