package Seminar_02;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Task_02 {
    private static Random rnd = new Random();

    public static void main(String[] args) {
        prepareFile();
    }

    static void prepareFile() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("names.txt", false);
            fileWriter.write("Анна=4\n");
            fileWriter.write("Елена=5\n");
            fileWriter.write("Марина=6\n");
            if (rnd.nextInt(2) == 0) {
                throw new Exception("Error.");
            }
            fileWriter.write("Владимир=?\n");
            fileWriter.write("Константин=?\n");
            fileWriter.write("Иван=4\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException ex) {
            }
        }
    }
}
