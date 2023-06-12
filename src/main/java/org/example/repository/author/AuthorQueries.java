package org.example.repository.author;

public class AuthorQueries {

    public static final String INSERT_INTO_AUTHOR = "insert into author(first_name, last_name" +
            ", age) values(?,?,?)";

    public static final String SELECT_AUTHOR_BY_ID = "select * from author where author_id=?";

    public static final String SELECT_ALL = "select * from author";

}
