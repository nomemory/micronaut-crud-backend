package net.andreinc.mn.crud.backend.service;

import io.micronaut.http.HttpResponse;
import net.andreinc.mn.crud.backend.dtos.BookDTO;
import net.andreinc.mn.crud.backend.dtos.requests.CreateBookDTO;
import net.andreinc.mn.crud.backend.entity.Author;
import net.andreinc.mn.crud.backend.entity.Book;
import net.andreinc.mn.crud.backend.exceptions.AuthorNotFoundException;
import net.andreinc.mn.crud.backend.repository.AuthorRepository;
import net.andreinc.mn.crud.backend.repository.BookRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Singleton
public class BookService {

    @Inject
    private AuthorRepository authorRepository;

    @Inject
    private BookRepository bookRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public Optional<BookDTO> getBook(Long id) {
        return bookRepository
                .findById(id)
                .map(book -> modelMapper.map(book, BookDTO.class));
    }

    public BookDTO createBook(CreateBookDTO createBookDTO) {
        Book book = modelMapper.map(createBookDTO, Book.class);
        Set<Author> authors = new HashSet<>();
        for(var id : createBookDTO.getAuthorIds()) {
            Optional<Author> opt = authorRepository.findById(id);
            if (opt.isPresent()) {
                authors.add(opt.get());
            }
            else {
                throw new AuthorNotFoundException();
            }
        }
        book.setAuthors(authors);
        return modelMapper.map(bookRepository.save(book), BookDTO.class);
    }
}
