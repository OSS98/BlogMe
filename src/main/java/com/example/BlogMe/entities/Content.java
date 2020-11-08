package com.example.BlogMe.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Content{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String text;
    private String author;
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now();

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public LocalDate getDate() {
        return date;
    }
    public LocalTime getTime() {
        return time;
    }
    public int getId() {
        return id;
    }
    public String getText() {
        return text;
    }
    public String getTitle() {
        return title;
    }

}