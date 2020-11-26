package net.andreinc.mn.crud.backend.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import net.andreinc.mn.crud.backend.dtos.BookDTO;
import net.andreinc.mn.crud.backend.dtos.requests.CreateBookDTO;
import net.andreinc.mn.crud.backend.entity.Author;
import net.andreinc.mn.crud.backend.entity.Book;
import net.andreinc.mn.crud.backend.exceptions.AuthorNotFoundException;
import net.andreinc.mn.crud.backend.service.BookService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static io.micronaut.http.MediaType.TEXT_JSON;

/**
 * Requires authentication JWT
 * User Header:
 * Authorization : Bearer [jwt token] when calling the rest api
 */

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/book")
public class BookController {

    @Inject
    private BookService bookService;

    private ModelMapper modelMapper = new ModelMapper();

    @Post
    @Produces(TEXT_JSON)
    public HttpResponse<BookDTO> createBook(@Body CreateBookDTO createBookDTO) {
        try {
            return HttpResponse.ok().body(bookService.createBook(createBookDTO));
        } catch (AuthorNotFoundException ex) {
            return HttpResponse.notFound();
        }
    }

    @Get("/{id}")
    public HttpResponse<BookDTO> getBook(@PathVariable Long id) {
        Optional<BookDTO> bookOpt = bookService.getBook(id);
        if (bookOpt.isPresent()) {
            return HttpResponse.ok().body(bookOpt.get());
        }
        else {
            return HttpResponse.notFound();
        }
    }
}
