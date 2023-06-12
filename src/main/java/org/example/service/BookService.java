package org.example.service;

import org.example.entity.Book;
import org.example.repository.book.BookRepository;
import org.example.repository.book.BookRepositoryImpl;

import java.util.Date;

public class BookService {

    private BookRepositoryImpl bookRepository;

    public void addBook(String title, Date publishedYear, Long authorId) {
        Book book = new Book();
        book.setTitle(title);
        book.setPublishedYear(publishedYear);
        book.setAuthorId(authorId);
        bookRepository.save(book);
    }

}
