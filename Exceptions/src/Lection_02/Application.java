package Lection_02;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
//        String name = null;
//        System.out.println(name.length());   // NullPointerException
//        Object object = new String("123");
//        File file = (File) object;
//        System.out.println(file); // ClassCastException
//        String number = "123fq";
//        int i = Integer.parseInt(number);
//        System.out.println(i); // NumberFormatException
//        List<Object> emptyList = Collections.emptyList();
//        emptyList.add(new Object()); //UnsupportedOperationException
        int number = 1;
        try {
            number = 10 / 1;
            String name = null;
            System.out.println(name.length());
        } catch (ArithmeticException e) {
            System.out.println("Operation divide by zero not supported");
        } catch (NullPointerException e){
            System.out.println("NullPointerException");
        }
        System.out.println(number);

    }
}
