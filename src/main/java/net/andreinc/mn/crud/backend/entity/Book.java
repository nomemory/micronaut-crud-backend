package net.andreinc.mn.crud.backend.entity;

import io.micronaut.core.annotation.Introspected;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Introspected
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private int pages;

    public Book(Long id, String title, int pages) {
        this.id = id;
        this.title = title;
        this.pages = pages;
    }

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
