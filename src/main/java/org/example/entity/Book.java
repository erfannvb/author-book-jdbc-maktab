package org.example.entity;

import java.util.Date;

public class Book {

    private Long bookId;

    private String title;

    private Date publishedYear;

    private Long authorId;

    public Book() {
    }

    public Book(String title, Date publishedYear, Long authorId) {
        this.title = title;
        this.publishedYear = publishedYear;
        this.authorId = authorId;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", publishedYear=" + publishedYear +
                ", authorId=" + authorId +
                '}';
    }
}
