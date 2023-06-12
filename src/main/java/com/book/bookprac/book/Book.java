package com.book.bookprac.book;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String title;
    @Column
    private Integer price;
    @Column
    private Integer star;
    @Column
    private String author;
    @Column
    private String publish;
    @Column
    private String image;
    @Column
    private String category;
    @Column
    private String babyCategory;
    @Column(name = "bookYear")
    private Integer year;
    @Column(name = "bookMonth")
    private Integer month;
    @Column
    private Integer inventory;

    public Book(String title, Integer price, Integer star, String author, String publish, String image, String category, String babyCategory, Integer year, Integer month, Integer inventory) {
        this.title = title;
        this.price = price;
        this.star = star;
        this.author = author;
        this.publish = publish;
        this.image = image;
        this.category = category;
        this.babyCategory = babyCategory;
        this.year = year;
        this.month = month;
        this.inventory = inventory;
    }


}
