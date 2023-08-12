package kz.zhantekov.springcourse.tz1.service;

import kz.zhantekov.springcourse.tz1.entity.Person;

import java.util.List;

public interface PersonService {

    Person addPerson(Person person);
    Person updatePerson(Person person);
    List<Person> getAllPeople();
    Person getPerson(Long id);
    void deletePerson(Long id);
    boolean existsPersonByFullName(String fullName);
}
