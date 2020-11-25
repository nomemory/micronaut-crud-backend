package net.andreinc.mn.crud.backend.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import net.andreinc.mn.crud.backend.commands.CreateBookReq;
import net.andreinc.mn.crud.backend.commands.CreateBookRep;
import net.andreinc.mn.crud.backend.entity.Book;
import net.andreinc.mn.crud.backend.repository.BookRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;

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
    private BookRepository bookRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Post
    @Produces(TEXT_JSON)
    public HttpResponse<CreateBookRep> createBook(@Body CreateBookReq createBookReq) {
        Book book = modelMapper.map(createBookReq, Book.class);
        CreateBookRep createBookRep = modelMapper.map(bookRepository.save(book), CreateBookRep.class);
        return HttpResponse.ok().body(createBookRep);
    }
}
