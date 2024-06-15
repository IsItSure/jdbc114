package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("John", "Doe", (byte) 30);
        System.out.println("User с именем – John добавлен в базу данных");

        userService.saveUser("Jane", "Doe", (byte) 25);
        System.out.println("User с именем – Jane добавлен в базу данных");

        userService.saveUser("Jim", "Beam", (byte) 45);
        System.out.println("User с именем – Jim добавлен в базу данных");

        userService.saveUser("Jack", "Daniels", (byte) 50);
        System.out.println("User с именем – Jack добавлен в базу данных");

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();

        Util.shutdown();
    }
}
