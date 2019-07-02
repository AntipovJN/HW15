package Services;

import lib.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean pseudoAuthorisation(String login, String pass) {
        if (!login.equals("admin") || !pass.equals("admin")) {
            System.out.println("Не правильный логин, или пароль. Попробуйте еще раз \n");
            return false;
        }
        return true;
    }
}
