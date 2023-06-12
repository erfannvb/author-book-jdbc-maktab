package org.example.repository.book;

import org.example.connection.JdbcConnection;
import org.example.entity.Book;

import java.sql.*;

import static org.example.repository.book.BookQueries.*;

public class BookRepositoryImpl implements BookRepository {

    private Connection connection = null;

    private PreparedStatement preparedStatement = null;

    private ResultSet resultSet = null;

    @Override
    public void save(Book book) {
        try {
            connection = JdbcConnection.getConnection();
            if (connection == null)
                System.out.println("Error getting the connection.");

            preparedStatement = connection.prepareStatement(INSERT_INTO_BOOK);

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setDate(2, (Date) book.getPublishedYear());
            preparedStatement.setLong(3, book.getAuthorId());

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JdbcConnection.closeConnection(connection);
                JdbcConnection.closePreparedStatement(preparedStatement);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Book load(Long bookId) {
        Book book = new Book();
        try {

            connection = JdbcConnection.getConnection();
            if (connection == null)
                System.out.println("Error getting the connection.");

            preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);
            preparedStatement.setLong(1, bookId);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("book_id");
                String title = resultSet.getString("title");
                Date publishedYear = resultSet.getDate("published_year");
                Long authorId = resultSet.getLong("author_id");
                System.out.println(id + ": " + title + " " + publishedYear + " " + authorId);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JdbcConnection.closeConnection(connection);
                JdbcConnection.closePreparedStatement(preparedStatement);
                JdbcConnection.closeResultSet(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return book;
    }

    @Override
    public Book[] loadAll() {
        Book[] books;
        try {

            connection = JdbcConnection.getConnection();
            if (connection == null)
                System.out.println("Error getting the connection.");

            preparedStatement = connection.prepareStatement(SELECT_ALL,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            resultSet = preparedStatement.executeQuery();

            int size = 0;
            resultSet.last();
            size = resultSet.getRow();
            resultSet.beforeFirst();

            books = new Book[size];

            int count = 0;

            while (resultSet.next()) {
                Book book = new Book();
                book.setBookId(resultSet.getLong("book_id"));
                book.setTitle(resultSet.getString("title"));
                book.setPublishedYear(resultSet.getDate("published_year"));
                book.setAuthorId(resultSet.getLong("author_id"));
                books[count++] = book;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JdbcConnection.closeConnection(connection);
                JdbcConnection.closePreparedStatement(preparedStatement);
                JdbcConnection.closeResultSet(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return books;
    }

    @Override
    public void delete(Book book) {
        try {

            connection = JdbcConnection.getConnection();
            if (connection == null)
                System.out.println("Error getting the connection.");

            preparedStatement = connection.prepareStatement(DELETE_BOOK);
            preparedStatement.setLong(1, book.getBookId());

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JdbcConnection.closeConnection(connection);
                JdbcConnection.closePreparedStatement(preparedStatement);
                JdbcConnection.closeResultSet(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public long loadId() {
        long bookId = 0;
        try {

            connection = JdbcConnection.getConnection();
            if (connection == null)
                System.out.println("Error getting the connection.");

            preparedStatement = connection.prepareStatement(SELECT_ALL);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                bookId = resultSet.getLong("book_id");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JdbcConnection.closeConnection(connection);
                JdbcConnection.closePreparedStatement(preparedStatement);
                JdbcConnection.closeResultSet(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return bookId;
    }
}
