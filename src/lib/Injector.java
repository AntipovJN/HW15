package lib;

import Controllers.ConsoleHandler;
import DAO.BetDao;
import DAO.BetDaoImpl;
import Factory.BetDaoFactory;
import Factory.UserServiceFactory;
import Services.UserService;
import Services.UserServiceImpl;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDao> betDaoInterface = BetDao.class;
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<UserService> userServiceInterface = UserService.class;
        Class<UserServiceImpl> userServiceImplClass = UserServiceImpl.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(betDaoInterface) && betDaoImplClass.getAnnotation(Dao.class) != null) {
                    field.set(null, BetDaoFactory.getBetDao());
                }
                if (field.getType().equals(userServiceInterface) && userServiceImplClass.getAnnotation(Service.class) != null) {
                    field.set(null, UserServiceFactory.getUserService());
                }
            }

        }
    }
}
