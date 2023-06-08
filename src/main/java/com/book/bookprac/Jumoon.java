package com.book.bookprac;

import jakarta.persistence.*;

@Entity
public class Jumoon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer quantity;

}
