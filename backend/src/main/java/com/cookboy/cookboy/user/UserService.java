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
    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;

    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userDTOMapper)
                .collect(Collectors.toList());
    }

    public UserDTO getUser(int id) {
        return userRepository.findById(id)
                .stream()
                .map(userDTOMapper)
                .toList().get(0);
    }
}
