package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru",
              new Car("Mercedes-Benz", 63)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru",
              new Car("Hyundai", 40)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru",
              new Car("Pagani Zonda", 12)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru",
              new Car("Porshe", 911)));

      List<User> users = userService.listUsers();
      users.forEach(System.out::println);

      User user = userService.getUserByCar("Hyundai", 40);
      System.out.println(user);

      context.close();
   }
}