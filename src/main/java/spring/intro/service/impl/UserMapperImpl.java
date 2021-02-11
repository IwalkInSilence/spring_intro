package spring.intro.service.impl;

import org.springframework.stereotype.Component;
import spring.intro.dto.UserResponseDto;
import spring.intro.model.User;
import spring.intro.service.UserMapper;

@Component
public class UserMapperImpl implements UserMapper {
    public UserResponseDto parseToDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        return dto;
    }
}
