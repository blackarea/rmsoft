package com.example.rmsoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Book {

    private int book_id;
    @JsonProperty
    private String ISBN;
    private String name;
    private String author;
    private String publisher;
    private LocalDateTime pub_date;
}
