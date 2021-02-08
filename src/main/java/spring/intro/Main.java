package spring.intro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.intro.config.AppConfig;
import spring.intro.model.User;
import spring.intro.service.UserService;

public class Main {
    public static void main(String[] args) {
        User john = new User();
        john.setName("John");
        john.setLastname("Wick");
        john.setEmail("john.wick@lolosh.com");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

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

        userService.listUsers().forEach(System.out::println);
    }
}
