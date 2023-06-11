create table book
(
    book_id        serial primary key,
    title          varchar(100) not null,
    published_year date         not null
);

alter table book add author_id int;
alter table book add constraint fk_author_id foreign key (author_id) references author(author_id);