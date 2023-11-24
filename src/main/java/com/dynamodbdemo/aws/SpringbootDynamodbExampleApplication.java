package com.dynamodbdemo.aws;

import com.dynamodbdemo.aws.entity.Person;
import com.dynamodbdemo.aws.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class SpringbootDynamodbExampleApplication {

    @Autowired
    private PersonRepository repository;

    @PostMapping("/savePerson")
    public Person savePerson(@RequestBody Person person) {
        return repository.addPerson(person);
    }


    @GetMapping("/getPerson/{personId}")
    public Person findPerson(@PathVariable String personId) {
        return repository.findPersonByPersonId(personId);
    }

    @DeleteMapping("/deletePerson")
    public String deletePerson(@RequestBody Person person) {
        return repository.deletePerson(person);
    }

    @PutMapping("/editPerson")
    public String updatePerson(@RequestBody Person person) {
        return repository.editPerson(person);
    }

    @GetMapping("/welcome/{name}")
    public String welcome(@PathVariable String name) {
        return "Welcome to home page "+name+" Have a good day!!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDynamodbExampleApplication.class, args);
    }

}
