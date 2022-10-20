package com.mandiri.jpatokonyadia.dto;

public class Book {
    private String title;
    private Integer page;
    private Author author;

    public Book(String title, Integer page, Author author){
        this.title = title;
        this.page = page;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
