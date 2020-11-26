package net.andreinc.mn.crud.backend.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import net.andreinc.mn.crud.backend.dtos.AuthorDTO;
import net.andreinc.mn.crud.backend.dtos.requests.CreateAuthorDTO;
import net.andreinc.mn.crud.backend.entity.Author;
import net.andreinc.mn.crud.backend.repository.AuthorRepository;
import net.andreinc.mn.crud.backend.service.AuthorService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;

import java.util.Optional;

import static io.micronaut.http.MediaType.TEXT_JSON;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/author")
public class AuthorController {

    @Inject
    private AuthorRepository authorRepository;

    @Inject
    private AuthorService authorService;

    private ModelMapper modelMapper = new ModelMapper();

    @Post
    @Produces(TEXT_JSON)
    public HttpResponse<AuthorDTO> createAuthor(CreateAuthorDTO body) {
        AuthorDTO authorDTO = authorService.createAuthor(body);
        return HttpResponse.ok().body(authorDTO);
    }

    @Get("/{id}")
    public HttpResponse<AuthorDTO> getAuthor(@PathVariable Long id) {
        Optional<AuthorDTO> opt = authorService.getAuthor(id);
        if (opt.isPresent()) {
            return HttpResponse.ok().body(opt.get());
        }
        return HttpResponse.notFound();
    }

    @Delete("/{id}")
    public HttpResponse<?> deleteAuthor(@PathVariable Long id) {
        if (authorService.getAuthor(id).isPresent()) {
            authorService.deleteAuthor(id);
            return HttpResponse.ok();
        }
        return HttpResponse.notFound();
    }
}
