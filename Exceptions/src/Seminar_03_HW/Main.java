package Seminar_03_HW;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<User> users = new ArrayList<>();
    private static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите данные ФИО дата рождения (dd.mm.yyyy) телефон (10-ти значное число) " +
                    "пол (f|m) разделенные пробелом в произвольном порядке: ");
            String input = inputScanner.nextLine();
            try {
                users.add(enterUser(input));
            } catch (RuntimeException e) {
                System.out.println("Введенные данные некорректны.\n" + e.getMessage());
            }
            System.out.println("Ввести еще одного юзера? [y/Y]");
            input = inputScanner.nextLine().toLowerCase();
            if (!input.equals("y")) {
                break;
            }
        }
        for (User userPrint : users) {
            System.out.println(userPrint);
        }
        saveDataToFile(users);
    }

    public static User enterUser(String input) throws RuntimeException {
        String[] inputArray = input.split(" ");
        if (inputArray.length != 6) {
            throw new InputDateException("Количество данных не соответвует запросу.", input);
        }
        User user = new User();
        for (int i = 0; i < inputArray.length; i++) {
            try {
                user.addData(inputArray[i]);
            } catch (InputDateException e) {
                System.out.println(e.getMessage() + " Для строки. " + e.getString());
                throw new RuntimeException("Ошибка ввода данных пользователя.");
            }
        }
        return user;
    }

    public static void saveDataToFile(List<User> users) {
        for (User user : users) {
            try (FileWriter file = new FileWriter(user.getFamilyName(), true)) {
                file.write(user.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
