package Seminar_02_HW;

import java.util.Scanner;

public class Task_04 {
    private static Scanner scn = new Scanner(System.in);
    public static String inputString() throws MyEmptyStringException{
        String str = scn.nextLine();
        if (str == ""){
            throw new MyEmptyStringException("Некорректный ввод, пустая строка");
        }
        return str;
    }
}
