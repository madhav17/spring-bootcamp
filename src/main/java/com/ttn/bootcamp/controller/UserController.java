package com.ttn.bootcamp.controller;

import com.ttn.bootcamp.dto.UserDTO;
import com.ttn.bootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<UserDTO> list() {
        return userService.list();
    }

    /*
    *

 <!-- <item>
<id>1</id>
<name>1</name>
<birthDate>2021-10-07T19:08:44.783+00:00</birthDate>
</item> -->
*/
    @PostMapping(value = "/users")
    public UserDTO create(@RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @GetMapping("/users/{id}")
    public UserDTO get(@PathVariable("id") Long id) {
        return userService.get(id);
    }


    //    HATEOS - Hyper media as the engine of application state
//    https://www.springboottutorial.com/spring-boot-hateoas-for-rest-services

    @GetMapping("/users-hateos/{id}")
    public EntityModel<UserDTO> getUserHateos(@PathVariable("id") Long id) {
        UserDTO userDTO = userService.get(id);
        EntityModel<UserDTO> resource = EntityModel.of(userDTO);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).list());
        resource.add(linkTo.withRel("all-students"));
        return resource;
    }




}
