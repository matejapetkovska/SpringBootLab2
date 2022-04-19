package mk.ukim.finki.emt.lab2.service.impl;

import mk.ukim.finki.emt.lab2.model.Author;
import mk.ukim.finki.emt.lab2.model.Country;
import mk.ukim.finki.emt.lab2.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.emt.lab2.repository.AuthorRepository;
import mk.ukim.finki.emt.lab2.repository.CountryRepository;
import mk.ukim.finki.emt.lab2.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Author create(String name, String surname, Long countryId) {
        Country country=this.countryRepository.findById(countryId).orElseThrow(()-> new CountryNotFoundException(countryId));
        Author author=new Author(name,surname,country);
        return this.authorRepository.save(author);
    }
}
