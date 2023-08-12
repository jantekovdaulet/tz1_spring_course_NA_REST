package kz.zhantekov.springcourse.tz1.controller;

import jakarta.validation.Valid;
import kz.zhantekov.springcourse.tz1.entity.Book;
import kz.zhantekov.springcourse.tz1.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PostMapping
    public Book addBook(@RequestBody @Valid Book book) {
        return bookService.addBook(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody @Valid Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
