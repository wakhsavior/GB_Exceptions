package Lection_02;

import java.io.FileReader;
import java.io.IOException;

public class Application_2 {
    public static void main(String[] args) {
        FileReader test = null;
        try {
            test = new FileReader("TempFile.txt");
            test.read();
        }catch (RuntimeException | IOException e){
            System.out.println("Catch Exception "+e.getClass().getSimpleName());
        }
        finally {
            System.out.println("Finally start");
            if (test!=null){
                try {
                    test.close();
                }catch (IOException e){
                    System.out.println("Exception while close");
                }
            }
            System.out.println("Finally finish");
        }
    }
}
