package org.example.repository.author;

import org.example.connection.JdbcConnection;
import org.example.entity.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.repository.author.AuthorQueries.INSERT_INTO_AUTHOR;
import static org.example.repository.author.AuthorQueries.SELECT_ALL;

public class AuthorRepositoryImpl implements AuthorRepository {

    private static final Logger logger = LoggerFactory.getLogger(AuthorRepositoryImpl.class);

    private static final String CONNECTION_ERROR = "Error getting the connection.";

    private Connection connection = null;

    private PreparedStatement preparedStatement = null;

    private ResultSet resultSet = null;

    @Override
    public void save(Author author) {
        try {

            connection = JdbcConnection.getConnection();
            if (connection == null)
                logger.info(CONNECTION_ERROR);

            preparedStatement = connection.prepareStatement(INSERT_INTO_AUTHOR);

            preparedStatement.setString(1, author.getFirstName());
            preparedStatement.setString(2, author.getLastName());
            preparedStatement.setInt(3, author.getAge());

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
    public Long saveAndReturnAuthorId(Author author) {
        Long authorId;
        try {

            connection = JdbcConnection.getConnection();
            if (connection == null)
                logger.info(CONNECTION_ERROR);

            preparedStatement = connection.prepareStatement(INSERT_INTO_AUTHOR,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, author.getFirstName());
            preparedStatement.setString(2, author.getLastName());
            preparedStatement.setInt(3, author.getAge());

            preparedStatement.execute();

            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            authorId = resultSet.getLong("author_id");

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
        return authorId;
    }

    @Override
    public Author load(Long authorId) {
        Author author = new Author();
        try {

            connection = JdbcConnection.getConnection();
            if (connection == null)
                logger.info(CONNECTION_ERROR);

            preparedStatement = connection.prepareStatement(INSERT_INTO_AUTHOR);
            preparedStatement.setLong(1, authorId);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("author_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                System.out.println(id + ": " + firstName + " " + lastName + " " + age);
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
        return author;
    }

    @Override
    public Author[] loadAll() {
        Author[] authors;
        try {

            connection = JdbcConnection.getConnection();
            if (connection == null)
                logger.info(CONNECTION_ERROR);

            preparedStatement = connection.prepareStatement(SELECT_ALL,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            int size = 0;
            resultSet.last();
            size = resultSet.getRow();
            resultSet.beforeFirst();

            authors = new Author[size];

            int count = 0;

            while (resultSet.next()) {
                Author author = new Author();
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));
                author.setAge(resultSet.getInt("age"));
                authors[count++] = author;
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
        return authors;
    }

    @Override
    public long loadId() {
        long authorId = 0;
        try {

            connection = JdbcConnection.getConnection();
            if (connection == null)
                logger.info(CONNECTION_ERROR);

            preparedStatement = connection.prepareStatement(SELECT_ALL);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                authorId = resultSet.getLong("author_id");

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
        return authorId;
    }
}
