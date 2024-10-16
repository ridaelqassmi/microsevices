package com.elqassmi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Recommandation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recommendationId;

    private long productId;

    private String author;
    private String role;
    private String content;
}
