package org.example.service;

import org.example.entity.Author;
import org.example.repository.author.AuthorRepositoryImpl;

public class AuthorService {

    private AuthorRepositoryImpl authorRepository;

    private BookService bookService;

    public void register(String firstName, String lastName, int age) {
        Author author = new Author();
        author.setAuthorId(authorIdGenerator());
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setAge(age);
        authorRepository.save(author);
    }

    public void printAuthorInfo() {
        Author[] authors = authorRepository.loadAll();
        for (int i = 0; i < authors.length; i++) {
            authors[i].setBooks(bookService.authorBookList((long) (i + 1)));
        }
        for (Author author : authors) {
            System.out.println(author.getFirstName() + " " + author.getLastName());
        }
    }

    private long authorIdGenerator() {
        long generator = authorRepository.loadId() + 1;
        if (generator == 0) generator = 1;
        return generator;
    }

}
