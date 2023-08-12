package kz.zhantekov.springcourse.tz1.controller;

import jakarta.validation.Valid;
import kz.zhantekov.springcourse.tz1.entity.Person;
import kz.zhantekov.springcourse.tz1.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
@RequiredArgsConstructor
public class PeopleController {

    private final PersonService personService;

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.getPerson(id);
    }

    @PostMapping
    public Person addPerson(@RequestBody @Valid Person person) {
        return personService.addPerson(person);
    }

    @PutMapping
    public Person updatePerson(@RequestBody @Valid Person person) {
        return personService.updatePerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}
