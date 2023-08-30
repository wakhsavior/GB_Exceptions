package Seminar_02_HW;

import java.util.Scanner;

public class Task_01 {
    private static Scanner input = new Scanner(System.in);


    public static float inputFloat() {
        float result;
        System.out.printf("Введите дробное число: ");
        while (true) {
            try {
                String input_data = input.nextLine();
                return result = Float.parseFloat(input_data);
            } catch (NumberFormatException e) {
                System.out.printf("Введите дробное число: ");
            }
        }
    }
}
