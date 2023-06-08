package com.book.bookprac;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private Integer price;
    @Column
    private Integer star;
    @Column
    private String Author;
    @Column
    private String publish;
    @Column
    private String image;
    @Column
    private String category;
    @Column
    private String babyCategory;
    @Column
    private Integer year;
    @Column
    private Integer month;
    @Column
    private Integer inventory;

}
