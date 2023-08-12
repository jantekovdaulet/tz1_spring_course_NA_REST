package kz.zhantekov.springcourse.tz1.repository;

import kz.zhantekov.springcourse.tz1.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByPersonId(Long personId);
}
