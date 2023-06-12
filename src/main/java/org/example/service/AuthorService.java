package org.example.service;

import org.example.entity.Author;
import org.example.repository.author.AuthorRepositoryImpl;

public class AuthorService {

    private AuthorRepositoryImpl authorRepository;

    public void register(String firstName, String lastName, int age) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setAge(age);
        authorRepository.save(author);
    }

}
