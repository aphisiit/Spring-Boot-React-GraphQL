package com.example.demoql.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String name;

    private String isbn;

    private String author;

    private Float price;

    private Integer numberOfBook;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishDate;
}
