package com.alknslm.main;

import com.alknslm.model.User;
import com.alknslm.services.LoginService;
import com.alknslm.services.UserService;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); //bu method @configuration anotasyonuyla işaretlediğin classı ister
        UserService userService = context.getBean(UserService.class);

        for(User user : userService.getUserList()) {
            System.out.println(user);
        }

        LoginService loginService = new LoginService();
        loginService.login();
        /** User servic methoduna hem main'den hem loginservicinden erişim sağlamış olduk*/
    }
}
