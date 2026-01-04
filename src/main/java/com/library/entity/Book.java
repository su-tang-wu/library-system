package com.library.entity;

import lombok.Data;

@Data
public class Book {
    private Integer id;
    //name
    private String name;
    private String author;
    private String publisher;
    private Integer stock;
    private String category;
}
