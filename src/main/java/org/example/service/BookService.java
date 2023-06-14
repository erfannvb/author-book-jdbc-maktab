package org.example.service;

import org.example.entity.Book;
import org.example.repository.book.BookRepositoryImpl;

import java.util.Objects;

public class BookService {

    private BookRepositoryImpl bookRepository = new BookRepositoryImpl();

    public void addBook(String title, int publishedYear, long authorId) {
        bookRepository = new BookRepositoryImpl();
        Book book = new Book();
        book.setBookId(bookIdGenerator());
        book.setTitle(title);
        book.setPublishedYear(publishedYear);
        book.setAuthorId(authorId);
        bookRepository.save(book);
    }

    public Book[] authorBookList(Long authorId) {
        Book[] books = bookRepository.loadAll();
        Book[] authorBooks = new Book[books.length];
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (Objects.equals(books[i].getAuthorId(), authorId)) {
                authorBooks[count] = books[i];
                count++;
            }
        }
        return authorBooks;
    }

    private long bookIdGenerator() {
        return bookRepository.loadId() + 1;
    }

}
