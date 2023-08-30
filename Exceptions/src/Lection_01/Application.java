package Lection_01;

import java.io.File;

public class Application {
    public static void main(String[] args) {
//        String dir = System.getProperty("user.dir");
//        System.out.println(dir);
//        System.out.println(getFileSize(new File("TempFile.txt")));
        System.out.println(div(10, 0));
    }

    public static int div(int a, int b) {
        if (b == 0) {
            throw new RuntimeException("Divide by zero not permitted");
        }
        return a / b;
    }

    public static int divide(int a1, int a2) {
        if (a2 == 0) {
            return -1;
        }
        return a1 / a2;
    }

    public static long getFileSize(File file) {
        if (!file.exists()) {
            return -1L;
        }
        return file.length();
    }
}
