package org.example.repository.book;

public class BookQueries {

    public static final String INSERT_INTO_BOOK = "insert into book (title, published_year, author_id)" +
            " values (?,?,?)";

    public static final String SELECT_BOOK_BY_ID = "select * from book where book_id=?";

    public static final String SELECT_ALL = "select * from book";

    public static final String DELETE_BOOK = "delete from book where book_id=?";

}
