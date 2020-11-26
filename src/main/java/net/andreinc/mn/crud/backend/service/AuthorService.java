package net.andreinc.mn.crud.backend.service;

import net.andreinc.mn.crud.backend.dtos.AuthorDTO;
import net.andreinc.mn.crud.backend.dtos.requests.CreateAuthorDTO;
import net.andreinc.mn.crud.backend.entity.Author;
import net.andreinc.mn.crud.backend.repository.AuthorRepository;
import net.andreinc.mn.crud.backend.repository.BookRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class AuthorService {

    @Inject
    private AuthorRepository authorRepository;

    @Inject
    private BookRepository bookRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public AuthorDTO createAuthor(CreateAuthorDTO body) {
        Author author = modelMapper.map(body, Author.class);
        return modelMapper.map(authorRepository.save(author), AuthorDTO.class);
    }

    public Optional<AuthorDTO> getAuthor(Long id) {
        return authorRepository
                .findById(id)
                .map(author -> modelMapper.map(author, AuthorDTO.class));
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
