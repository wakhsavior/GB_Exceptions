package Seminar_03;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Task1 {
    public static void main(String[] args) {
        try {
            test1();
        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }
        try {
            test2(new String[]{"AA", "BB", null, "DD"}, 2);
        } catch (NullElementArrayException e) {
            System.out.printf("%s по индексу %d\n", e.getMessage(), e.getIndex());
        }
        try {
            test3("D:/AAA/AAA.txt");
        }catch (MyFileNotFoundException e){
            System.out.printf("%s\nНаименование файла: %s\n", e.getMessage(),e.getFilename());
        }


    }

    static void test1() {
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            throw new DivisionByZeroException("Ошибка деления числа на 0.");
        }
    }

    static void test2(String[] array, int index) {
        try {
            if (array[index] == null) {
                throw new NullElementArrayException("Элемент массива не проинициализирован", index);
            }
            System.out.printf("Значение элемента массива: %s\n", array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    static void test3(String filename) throws MyFileNotFoundException {
        try {
            FileReader fileReader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            throw new MyFileNotFoundException("Файл не найден", filename);
        }


    }
}

class MyFileNotFoundException extends Exception {
    private String filename;

    public MyFileNotFoundException(String message, String filename) {
        super(message);
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}

class NullElementArrayException extends NullPointerException {
    private final int index;

    public int getIndex() {
        return index;
    }

    public NullElementArrayException(String s, int index) {
        super(s);
        this.index = index;
    }
}

class DivisionByZeroException extends ArithmeticException {
    public DivisionByZeroException(String s) {
        super(s);
    }
}
