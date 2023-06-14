package org.example.view;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.service.AuthorService;
import org.example.service.BookService;

public class PrintList {

    private AuthorService authorService = new AuthorService();
    private BookService bookService = new BookService();

    public void createAuthor() {
        String[] authorFirstName = {"Erfan", "Mehdi", "Ali", "Kamran"};
        String[] authorLastName = {"Navab", "Arghan", "Jafari", "Tafti"};
        for (int i = 0; i < authorFirstName.length; i++) {
            authorService.register(authorFirstName[i], authorLastName[i], i + 20);
        }
        System.out.println("List of author created.");
    }

    public void createBook() {
        String[] title = {"AI", "Math", "History", "Culture"};
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int publishedYear = 2016;
                bookService.addBook(title[j], publishedYear + j, i);
            }
        }
        System.out.println("List of books created.");
    }

    public void printAuthorBook(Long authorId) {
        for (Book book : bookService.authorBookList(authorId)) {
            if (book != null) System.out.println(book.getTitle());
        }
    }

    public void sortAuthor(Author[] authors) {

        int size = 0;

        String[] lastName = new String[authors.length];
        for (int i = 0; i < authors.length; i++) {
            lastName[i] = authors[i].getLastName();
        }

        Author authorTemp;
        String temp;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                authorTemp = authors[i];
                temp = lastName[i];
                authors[i] = authors[j];
                lastName[i] = lastName[j];
                authors[j] = authorTemp;
                lastName[j] = temp;
            }
        }

        System.out.println("The author family in alphabetical order are: ");
        for (int i = 0; i < size; i++) {
            System.out.println("ID:" + authors[i].getAuthorId() +
                    "  family of this author is :" + authors[i].getLastName());
        }
    }

}
