package org.example.entity;

public class Author {

    private Long authorId;

    private String firstName;

    private String lastName;

    private int age;

    private Book[] books = new Book[10];

    public Author() {
    }

    public Author(Long authorId, String firstName, String lastName, int age, Book[] books) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.books = books;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
}
