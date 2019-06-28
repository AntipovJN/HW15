import Controllers.ConsoleHandler;
import DAO.BetDao;
import DAO.BetDaoImpl;
import lib.Injector;

public class Main {

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImpl();
        System.out.println(betDao.getAll());
    }
}
