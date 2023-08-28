package org.example.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String marque;
    private String reference;
    private Date daeAchat;

    private Double prix;

    private int stock;

}
