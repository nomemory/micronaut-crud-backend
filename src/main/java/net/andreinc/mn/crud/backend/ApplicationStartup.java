package net.andreinc.mn.crud.backend;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.StartupEvent;
import net.andreinc.mn.crud.backend.dtos.requests.CreateAuthorDTO;
import net.andreinc.mn.crud.backend.dtos.requests.CreateBookDTO;
import net.andreinc.mn.crud.backend.entity.Author;
import net.andreinc.mn.crud.backend.entity.Book;
import net.andreinc.mn.crud.backend.repository.AuthorRepository;
import net.andreinc.mn.crud.backend.repository.BookRepository;
import net.andreinc.mn.crud.backend.service.AuthorService;
import net.andreinc.mn.crud.backend.service.BookService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashSet;
import java.util.Set;

@Singleton
public class ApplicationStartup implements ApplicationEventListener<StartupEvent> {

    @Inject
    private AuthorService authorService;

    @Inject
    private BookService bookService;

    @Override
    public void onApplicationEvent(StartupEvent event) {

        authorService.createAuthor(new CreateAuthorDTO("Mike", "Smith"));
        authorService.createAuthor(new CreateAuthorDTO("Jason", "Costello"));
        authorService.createAuthor(new CreateAuthorDTO("Lisa", "Evans"));

        bookService.createBook(new CreateBookDTO( "Kotlin in Action", 100, Set.of(1L, 2L)));
        bookService.createBook(new CreateBookDTO( "Java in Action", 200, Set.of(1L, 3L)));
        bookService.createBook(new CreateBookDTO( "C++ in Action", 150, Set.of(2L)));
    }
}
