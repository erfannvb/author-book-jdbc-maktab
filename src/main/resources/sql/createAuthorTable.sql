create table author
(
    author_id  serial primary key,
    first_name varchar(50) not null,
    last_name  varchar(50) not null,
    age        int         not null,
    book_id    int,
    constraint fk_book_id foreign key (book_id) references book (book_id)
);

alter table author add book_id int;
alter table author add constraint fk_book_id foreign key (book_id) references book(book_id);