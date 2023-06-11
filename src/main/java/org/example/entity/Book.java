package org.example.entity;

import java.util.Date;

public class Book {

    private Long bookId;

    private String title;

    private Date publishedYear;

    private Author author;

    public Book() {
    }

    public Book(Long bookId, String title, Date publishedYear, Author author) {
        this.bookId = bookId;
        this.title = title;
        this.publishedYear = publishedYear;
        this.author = author;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Date publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
