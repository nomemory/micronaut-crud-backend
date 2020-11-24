package net.andreinc.mn.crud.backend.repository;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import net.andreinc.mn.crud.backend.entity.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
