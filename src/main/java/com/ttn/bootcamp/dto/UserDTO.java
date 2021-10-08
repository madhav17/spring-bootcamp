package com.ttn.bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true, value = {"password"})
@ApiModel(description = "User validation")
@JsonFilter("user filter")
public class UserDTO {


    private Long id;

    @ApiModelProperty(notes = "Name should have atleast 2 charater")
    private String name;
    @ApiModelProperty(notes = "Date can't be in past")
    private Date birthDate;

    //    @JsonIgnore
    private String password = "password";

    public UserDTO() {

    }

    public UserDTO(Long id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
