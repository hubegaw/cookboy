package com.cookboy.cookboy.user;

import com.cookboy.cookboy.dto.UserDTO;
import com.cookboy.cookboy.dto.UserDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserDTOMapper userDTOMapper;

    public List<UserDTO> getUsers() {
        return repository.findAll()
                .stream()
                .map(userDTOMapper)
                .collect(Collectors.toList());
    }
}
