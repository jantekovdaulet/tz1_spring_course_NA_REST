package kz.zhantekov.springcourse.tz1.service.impl;

import jakarta.transaction.Transactional;
import kz.zhantekov.springcourse.tz1.entity.Book;
import kz.zhantekov.springcourse.tz1.entity.Person;
import kz.zhantekov.springcourse.tz1.exception.BadRequestException;
import kz.zhantekov.springcourse.tz1.repository.BookRepository;
import kz.zhantekov.springcourse.tz1.repository.PersonRepository;
import kz.zhantekov.springcourse.tz1.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final BookRepository bookRepository;

    @Transactional
    @Override
    public Person addPerson(Person person) {

        if (person.getId() != null)
            throw new BadRequestException("Person ID Error", "Person already has ID");

        if (personRepository.existsByFullName(person.getFullName()))
            throw new BadRequestException("Email Error", "This email already exists");

        return personRepository.save(person);
    }

    @Transactional
    @Override
    public Person updatePerson(Person person) {

        if (person.getId() == null)
            throw new BadRequestException("Person ID Error", "Person does not have ID");

        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @Override
    public Person getPerson(Long id) {

        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) return person.get();

        throw new BadRequestException("Person Not Found Error", "Person does not exist");
    }

    @Transactional
    @Override
    public void deletePerson(Long id) {

        Optional<Person> person = personRepository.findById(id);
        if (person.isEmpty())
            throw new BadRequestException("Person Not Found Error", "Person does not exist");

        List<Book> books = bookRepository.findByPersonId(id);
        if (!books.isEmpty()){
            books.forEach(book -> book.setPerson(null));
            bookRepository.saveAll(books);
        }

        personRepository.deleteById(id);
    }

    @Override
    public boolean existsPersonByFullName(String fullName) {
        return personRepository.existsByFullName(fullName);
    }
}
