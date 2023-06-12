package org.example.repository.author;

import org.example.entity.Author;

public interface AuthorRepository {

    void save(Author author);

    Long saveAndReturnAuthorId(Author author);

    Author load(Long authorId);

    Author[] loadAll();

}
