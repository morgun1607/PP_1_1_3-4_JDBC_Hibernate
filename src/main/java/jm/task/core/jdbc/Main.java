
package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Иван", "Иванов", (byte) 25);
        userService.saveUser("Петр", "Петров", (byte) 30);
        userService.saveUser("Алексей", "Сидоров", (byte) 28);
        userService.saveUser("Дмитрий", "Смирнов", (byte) 35);

        for (User user : userService.getAllUsers()) {
            System.out.println(
                    user.getId() + " | " +
                            user.getName() + " | " +
                            user.getLastName() + " | " +
                            user.getAge()
            );
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
