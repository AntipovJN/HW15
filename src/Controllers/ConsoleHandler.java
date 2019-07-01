package Controllers;

import DAO.BetDao;
import Entity.Bet;
import Services.UserService;
import lib.Inject;

import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private static BetDao betDao;

    @Inject
    private static UserService userService;

    static public void handle() {
        if (betDao == null || userService == null) {
            System.out.println("Нет подключения, повторите попытку ...");
            return;
        }
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Перед началом работы нужно авторизироваться. Введите логин и пароль");
            while (userService.pseudoAuthorisation(scanner.nextLine(), scanner.nextLine())) { //login: admin , pass: admin
                System.out.println("Авторизация прошла успешно \n\n" +
                        "Если хотите сделать ставку, введите cумму и риск через пробел");
                while (true) {
                    String command = scanner.nextLine();
                    if (command.equals("0")) {
                        return;
                    }
                    String[] data = command.split(" ");
                    int value = Integer.parseInt(data[0]);
                    double risk = Double.parseDouble(data[1]);
                    Bet bet = new Bet(value, risk);
                    betDao.add(bet);
                }
            }
        } catch (Exception e) {
            System.out.println("Данные введены некорректно");
        }
    }
}
