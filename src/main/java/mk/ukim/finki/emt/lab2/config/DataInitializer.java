package mk.ukim.finki.emt.lab2.config;

import mk.ukim.finki.emt.lab2.model.enumerations.Category;
import mk.ukim.finki.emt.lab2.service.AuthorService;
import mk.ukim.finki.emt.lab2.service.BookService;
import mk.ukim.finki.emt.lab2.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class DataInitializer {

    private final AuthorService authorService;
    private final CountryService countryService;
    private final BookService bookService;

    public DataInitializer(AuthorService authorService, CountryService countryService, BookService bookService) {
        this.authorService = authorService;
        this.countryService = countryService;
        this.bookService = bookService;
    }


    @PostConstruct
    public void initData() {
        this.countryService.create("United Kingdom","Europe");
        this.authorService.create("Joanne", "Rowling", 1L);
        this.bookService.save("Harry Potter", Category.FANTASY,1L,10);

        this.countryService.create("Russia","Europe");
        this.authorService.create("Leo", "Tolstoy", 2L);
        this.bookService.save("War and Peace", Category.NOVEL,2L,20);

        this.bookService.save("Anna Karenina", Category.CLASSICS,2L,25);

        this.authorService.create("Fyodor", "Dostoevsky", 2L);
        this.bookService.save("Crime and Punishment", Category.DRAMA,3L,8);

        this.countryService.create("South Africa","Africa");
        this.authorService.create("John", "Tolkien", 3L);
        this.bookService.save("The Lord of the Rings", Category.FANTASY,4L,50);

        this.countryService.create("United States","America");
        this.authorService.create("Walter", "Isaacson", 4L);
        this.bookService.save("Steve Jobs", Category.BIOGRAPHY,5L,80);
    }
}