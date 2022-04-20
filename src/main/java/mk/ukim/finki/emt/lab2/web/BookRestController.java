package mk.ukim.finki.emt.lab2.web;

import mk.ukim.finki.emt.lab2.model.Book;
import mk.ukim.finki.emt.lab2.model.dto.BookDto;
import mk.ukim.finki.emt.lab2.model.enumerations.Category;
import mk.ukim.finki.emt.lab2.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://reactapp-lab2.herokuapp.com/")
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll()
    {
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id)
    {
        return this.bookService.findById(id).map(book -> ResponseEntity.ok().body(book)).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/categories")
    public List<Category> findCategories()
    {
        return List.of(Category.values());
    }

    @PostMapping("/add")
    private ResponseEntity<Book> save(@RequestBody BookDto bookDto){
        return this.bookService.save(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@RequestBody BookDto bookDto,@PathVariable Long id)
    {
        return this.bookService.edit(id,bookDto).map(book -> ResponseEntity.ok().body(book)).orElseGet(()->ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id)
    {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/markastaken/{id}")
    public ResponseEntity markAsTaken(@PathVariable Long id)
    {
        return this.bookService.markAsTaken(id).map(book -> ResponseEntity.ok().body(book)).orElseGet(()->ResponseEntity.badRequest().build());
    }
}
