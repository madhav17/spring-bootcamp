package com.ttn.bootcamp.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.ttn.bootcamp.dto.UserDTO;
import com.ttn.bootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilteringController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/filter-users")
    public List<UserDTO> list() {
        return userService.list();
    }

    @GetMapping(value = "/filter-users/{id}")
    public MappingJacksonValue get_user(@PathVariable("id") Long id) {
        UserDTO userDTO = userService.get(id);
        MappingJacksonValue mapping = new MappingJacksonValue(userDTO);
        SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("name");
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("user filter",filter);
        mapping.setFilters(filters);
        return mapping;
    }


}
