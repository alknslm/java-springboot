package config;

import com.alknslm.model.User;
import com.alknslm.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    /**Bu yöntem manuel usülle bean oluşturma
     * Diğer Yöntemler : RestController, Repository, Service*/
    @Bean
    public UserService userService() {
        UserService userService = new UserService();
        List<User> userList = new ArrayList<>();

        userList.add(new User("Ahmet"));
        userList.add(new User("Harun"));
        userService.setUserList(userList);

        return userService;
    }
}
