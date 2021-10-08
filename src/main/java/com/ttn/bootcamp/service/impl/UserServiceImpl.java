package com.ttn.bootcamp.service.impl;

import com.ttn.bootcamp.dto.UserDTO;
import com.ttn.bootcamp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public List<UserDTO> list() {
        List<UserDTO> list = new ArrayList<>();
        for (Long i = 1L; i <= 5L; i++) {
            list.add(new UserDTO(i, i.toString(), new Date()));
        }
        return list;
    }

    public UserDTO get(Long id) {
        return new UserDTO(id, id.toString(), new Date());
    }

    public UserDTO create(UserDTO userDTO) {
        return userDTO;
    }
}
