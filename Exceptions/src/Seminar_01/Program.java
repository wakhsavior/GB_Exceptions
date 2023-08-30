package Seminar_01;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        System.out.printf("Длина массива %d\n", task1(new int[]{}));
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

    }

    static int processArray(int[] array, int searchValue) {
        if (array == null) {
            return -3;// Массив инициализирован некорректно
        }
        if (array.length < 3) {
            return -1; //Длина массива менее
        }
        Arrays.sort(array);
        int searchResult = Arrays.binarySearch(array, searchValue);
        if (searchResult < 0) {
            return -2; //Элемент не найден
        }
        return searchResult;
    }
}
