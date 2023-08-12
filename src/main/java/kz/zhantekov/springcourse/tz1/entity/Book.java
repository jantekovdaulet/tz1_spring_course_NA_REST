package kz.zhantekov.springcourse.tz1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
// TODO add validation
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Book name should not be empty")
    @NotNull(message = "Book name should not be null")
    @Size(min = 2, max = 50, message = "Book name should be 2-50 letters")
    private String name;

    @NotBlank(message = "Author of book should not be empty")
    @NotNull(message = "Author of book should not be null")
    @Pattern(regexp = "^[A-Z][a-z]* [A-Z][a-z]*$", message = "Author of book should be valid")
    private String author;

    @NotNull(message = "Year of book should not be null")
    @Positive
    private int year;

    @ManyToOne
    private Person person;
}
