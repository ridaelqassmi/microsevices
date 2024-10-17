package com.elqassmi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewId;

    @NotNull(message = "L'ID du produit est requis")
    private long productId;

    @NotBlank(message = "L'auteur est requis")
    private String author;

    @NotBlank(message = "Le sujet est requis")
    private String subject;

    @NotBlank(message = "Le contenu est requis")
    private String content;
}
