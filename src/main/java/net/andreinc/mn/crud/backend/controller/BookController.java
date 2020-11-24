package net.andreinc.mn.crud.backend.controller;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import net.andreinc.mn.crud.backend.commands.CreateBook;
import net.andreinc.mn.crud.backend.entity.Book;
import net.andreinc.mn.crud.backend.repository.BookRepository;

import javax.inject.Inject;

import static io.micronaut.http.MediaType.TEXT_PLAIN;

@Controller("/book")
public class BookController {

    @Inject
    private BookRepository bookRepository;

    @Post
    @Produces(TEXT_PLAIN)
    public Long createBook(@Body CreateBook createBook) {
        Book book = new Book(createBook.getTitle(), createBook.getPages());
        return bookRepository.save(book).getId();
    }
}
