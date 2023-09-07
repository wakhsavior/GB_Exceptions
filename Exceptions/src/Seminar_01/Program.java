package Seminar_01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program {
    private static Scanner scn = new Scanner(System.in);
    private static Random rnd = new Random();

    public static void main(String[] args) {

//         System.out.printf("Длина массива %d\n", task1(new int[]{}));
        task5();
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента массив.
     * Если длина массива меньше некоторого заданого минимум,
     * метод возвращает -1 в качестве кода ошибки, иначе - длина массива
     *
     * @param array массив
     * @return длина массива (-1 -длина массива 0, -2 массив не проинициализирован)
     */
    static int task1(int[] array) {
        if (array == null) {
            return -2;
        }
        if (array.length == 0) {
            return -1;
        }
        return array.length;
    }

    static void task2() {
        while (true) {
            System.out.print("Укажите значение для поиска: ");
            int searchValue = Integer.parseInt(scn.nextLine());
            int[] array = new int[rnd.nextInt(0, 5) + 1];
            if (rnd.nextInt(3) == 0) {
                array = null;
            }
            if (array != null) {
                for (int i = 0; i < array.length; i++) {
                    array[i] = rnd.nextInt(10);
                    System.out.printf("%d\t", array[i]);
                }
                System.out.println();
            }
            int codeResult = processArray(array, searchValue);
            switch (codeResult) {
                case -1 -> System.out.println("Длина массива менее 3 символов");
                case -2 -> System.out.println("Элемент не найден");
                case -3 -> System.out.println("Массив проинициализирован некорректно");
                default -> {
                    System.out.println("Массив успешно обработан. Завершение работы приложения");
                    System.out.printf("Элемент найден по индексу: %d\n", codeResult);
                    return;
                }
            }
        }
    }

    static int processArray(int[] array, int searchValue) {
        if (array == null) {
            return -3;// Массив инициализирован некорректно
        }
        if (array.length < 3) {
            return -1; //Длина массива менее
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d\t", array[i]);
        }
        int searchResult = Arrays.binarySearch(array, searchValue);
        if (searchResult < 0) {
            return -2; //Элемент не найден
        }
        return searchResult;
    }

    static void task3() {
        for (int i = 0; i < 10; i++) {
            processArray(generateArray());
        }
    }

    static void processArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (array.length != array[i].length) {
                throw new RuntimeException("Некорректная размерность массива.");
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] != 0 && array[i][j] != 1) {
                    throw new RuntimeException(String.format("Некорректное значение массива по индексу [%d][%d]", i, j));
                } else {
                    sum += array[i][j];
                }
            }
        }
        System.out.printf("Сумма элементов массива: %d\n", sum);
    }

    static int[][] generateArray() {
        int[][] array = new int[rnd.nextInt(4, 6)][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = rnd.nextInt(2);
            }
        }
        if (rnd.nextInt(2) == 0) {
            array[0][0] = 2;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.printf("%d\t", array[i][j]);
            }
            System.out.println();
        }
        return array;
    }

    static void task4() {
        for (int i = 0; i < 10; i++) {
            int errCode = processArray_v2(generateArray());
            switch (errCode) {
                case -1 -> System.out.println("Некорректная размерность массива.");
                case -2 -> System.out.println("Некорректное значение массива.");
                default -> System.out.printf("Сумма элементов массива: %d\n", errCode);
            }
        }
    }

    static int processArray_v2(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (array.length != array[i].length) {
                return -1;
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] != 0 && array[i][j] != 1) {
                    return -2;
                } else {
                    sum += array[i][j];
                }
            }
        }
//        System.out.printf("Сумма элементов массива: %d\n", sum);
        return sum;
    }

    static void task5() {
//        try
//        catch
//        finally
        try{
            int[] arr = getSumArray(new int[] {1,0,-1,9,8}, /*new int[]{4,3,1,7,2}*/null);
            for (int e:arr){
                System.out.printf("%d\t",e);
            }
            System.out.println();
        }catch (CustomArraySizeException e){
            System.out.println(e.getMessage());
            System.out.printf("Длина первого массива %d\nДлина второго массива %d\n", e.getLength1(),e.getLength2());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    static int[] getSumArray(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            throw new NullPointerException("Оба массива должны существовать");
        }
        if (array1.length != array2.length) {
            throw new CustomArraySizeException("Количество элементов массива должно быть одинаковым", array1.length, array2.length);
        }
        int[] res = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            res[i] = array2[i] + array1[i];
        }
        return res;
    }
}
