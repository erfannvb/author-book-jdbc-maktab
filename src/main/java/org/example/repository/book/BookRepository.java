package org.example.repository.book;

import org.example.entity.Book;

public interface BookRepository {

    void save(Book book);

    Book load(Long bookId);

    Book[] loadAll();

    void delete(Book book);

}
