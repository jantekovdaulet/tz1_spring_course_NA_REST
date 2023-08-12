package kz.zhantekov.springcourse.tz1.entity;

import jakarta.validation.constraints.*;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Full Name should not be empty")
    @Size(min = 2, max = 50, message = "Full name should be 2-50 letters")
    @Pattern(regexp = "^[A-Z][a-z]* [A-Z][a-z]*$", message = "Full Name should be valid")
    @Column(unique = true)
    private String fullName;

    @NotNull(message = "Birth Year should not be null")
    @Min(value = 1900, message = "Birth Year should be valid")
    private int birthYear;
}
