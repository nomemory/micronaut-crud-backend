package net.andreinc.mn.crud.backend.repository;

import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import net.andreinc.mn.crud.backend.entity.Book;

import javax.inject.Singleton;

@Singleton
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @Executable
    Book find(String title);
}
