package Lection_03;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("TempFile.txt");
             FileWriter writer = new FileWriter("reader")) {
            while (reader.ready()) {
                writer.write(reader.read());
            }
        } catch (RuntimeException | IOException e) {
            System.out.println("Catch Exception " + e.getClass().getSimpleName());
        }
        try {
            System.out.println("test operation");
        } finally {
            System.out.println("Finally operation");
        }
    }
}
