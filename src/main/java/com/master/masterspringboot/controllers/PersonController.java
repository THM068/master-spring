package com.master.masterspringboot.controllers;

import com.master.masterspringboot.aop.SampleAdder;
import com.master.masterspringboot.configuration.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final SampleAdder sampleAdder;

    @Autowired
    public PersonController(SampleAdder sampleAdder) {
        this.sampleAdder = sampleAdder;
    }

    @GetMapping(value = "/person", produces = "application/json")
    public Person person() {
        sampleAdder.add(2,4);
        sampleAdder.getPassenger();
        return new Person("Thando");
    }
}
