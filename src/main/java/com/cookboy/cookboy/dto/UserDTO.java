package com.cookboy.cookboy.dto;

import java.util.List;

public record UserDTO(
        Integer id,
        String name,
        String email,
        List<String> roles
) {

}
