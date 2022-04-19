package mk.ukim.finki.emt.lab2.model.dto;

import lombok.Data;
import mk.ukim.finki.emt.lab2.model.enumerations.Category;


@Data
public class BookDto {

    private String name;

    private Category category;

    private Long author;

    private Integer availableCopies;

    public BookDto() {
    }

    public BookDto(String name, Category category, Long authorId, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = authorId;
        this.availableCopies = availableCopies;
    }
}
