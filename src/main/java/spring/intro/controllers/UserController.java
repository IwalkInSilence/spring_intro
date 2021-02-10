package spring.intro.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.intro.dto.UserResponseDto;
import spring.intro.model.User;
import spring.intro.service.UserMapper;
import spring.intro.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/inject")
    public String inject() {
        User john = new User();
        john.setName("John");
        john.setLastname("Wick");
        john.setEmail("john.wick@lolosh.com");
        userService.add(john);
        User chuck = new User();
        chuck.setName("Chuck");
        chuck.setLastname("Norris");
        chuck.setEmail("chuck.norris322@lolosh.com");
        userService.add(chuck);
        User jason = new User();
        jason.setName("Jason");
        jason.setLastname("Statham");
        jason.setEmail("bob@lolosh.com");
        userService.add(jason);
        User bruce = new User();
        bruce.setName("Bruce");
        bruce.setLastname("Willis");
        bruce.setEmail("alice@lolosh.com");
        userService.add(bruce);
        return "All users injected";
    }

    @GetMapping("/{id}")
    UserResponseDto get(@PathVariable Long id) {
        User user = userService.get(id);
        return userMapper.parseToDto(user);
    }

    @GetMapping("/")
    List<UserResponseDto> getall() {
        return userService.listUsers()
                .stream()
                .map(userMapper::parseToDto)
        .collect(Collectors.toList());
    }
}
