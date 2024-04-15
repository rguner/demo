package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {

    private int id;
    private String title;

    public String getTitle() {
        return "TITLE: " + title;
    }

}
