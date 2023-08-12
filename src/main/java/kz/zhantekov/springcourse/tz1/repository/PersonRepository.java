package kz.zhantekov.springcourse.tz1.repository;

import kz.zhantekov.springcourse.tz1.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    boolean existsByFullName(String fullName);
    Optional<Person> findByFullName(String fullName);
}
