package kz.zhantekov.springcourse.tz1.service.impl;

import kz.zhantekov.springcourse.tz1.entity.Book;
import kz.zhantekov.springcourse.tz1.exception.BadRequestException;
import kz.zhantekov.springcourse.tz1.repository.BookRepository;
import kz.zhantekov.springcourse.tz1.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {

        if (book.getId() != null)
            throw new BadRequestException("Book ID Error", "Book already has ID");

        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {

        if (book.getId() == null)
            throw new BadRequestException("Book ID Error", "Book does not have ID");

        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {

        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) return book.get();

        throw new BadRequestException("Book Not Found Error", "Book does not exist");
    }

    @Override
    public void deleteBook(Long id) {

        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty())
            throw new BadRequestException("Book Not Found Error", "Book does not exist");

        bookRepository.deleteById(id);
    }
}
