package Seminar_02_HW;

import java.util.Random;

public class Main {
    private static Random rnd = new Random();

    public static void main(String[] args) {
//        TASK_01
        //        System.out.println(Task_01.inputFloat());
//        TASK_02
//        int count;
//        for (int i = 0; i < 10; i++) {
//            count = rnd.nextInt(5, 12);
//            int[] array = new int[count];
//            for (int j = 0; j < count; j++) {
//                array[j] = rnd.nextInt(0, 1000);
//            }
//            Task_02.divide(array);
//        }

//    TASK_04
        while (true){
            System.out.printf("Введите строку: ");
            try {
                System.out.println(Task_04.inputString());
                return;
            } catch (MyEmptyStringException e){
                System.out.printf("%s. Повторите ввод строки\n",e);

            }
        }
    }
}
