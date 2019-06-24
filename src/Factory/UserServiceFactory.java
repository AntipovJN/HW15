package Factory;

import Services.UserServiceImpl;

public class UserServiceFactory {

   private static UserServiceImpl userService = null;

    public static UserServiceImpl getUserService() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }
}
