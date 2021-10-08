package com.ttn.bootcamp.controller;

import com.ttn.bootcamp.dto.PersonV1;
import com.ttn.bootcamp.dto.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @GetMapping("/v1/persons")
    public PersonV1 personV1() {
        return new PersonV1("Madhav Khanna");
    }

    @GetMapping("/v2/persons")
    public PersonV2 personV2() {
        return new PersonV2("Madhav", "Khanna");
    }

// using param

    @GetMapping(value = "/persons/param", params = "version=1")
    public PersonV1 paramV1() {
        return new PersonV1("Madhav Khanna");
    }


    @GetMapping(value = "/persons/param", params = "version=2")
    public PersonV2 paramV2() {
        return new PersonV2("Madhav", "Khanna");
    }

//    using header

    @GetMapping(value = "/persons/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1() {
        return new PersonV1("Madhav Khanna");
    }


    @GetMapping(value = "/persons/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2() {
        return new PersonV2("Madhav", "Khanna");
    }


//    using produces or accept header

    @GetMapping(value = "/persons/produces", produces = "application/com.ttn.bootcamp-v1+json")
    public PersonV1 producesV1() {
        return new PersonV1("Madhav Khanna");
    }


    @GetMapping(value = "/persons/produces", produces = "application/com.ttn.bootcamp-v2+json")
    public PersonV2 producesV2() {
        return new PersonV2("Madhav", "Khanna");
    }


}
