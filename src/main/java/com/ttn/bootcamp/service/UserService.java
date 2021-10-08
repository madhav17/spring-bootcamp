package com.ttn.bootcamp.service;

import com.ttn.bootcamp.dto.UserDTO;

import java.util.List;

public interface UserService {

    public List<UserDTO> list();

    public UserDTO get(Long id);

    public UserDTO create(UserDTO userDTO);
}
