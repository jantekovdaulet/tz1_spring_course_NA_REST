package kz.zhantekov.springcourse.tz1.service;

import kz.zhantekov.springcourse.tz1.entity.Book;

import java.util.List;

public interface BookService {

    Book addBook(Book book);
    Book updateBook(Book book);
    List<Book> getAllBooks();
    Book getBook(Long id);
    void deleteBook(Long id);
}
