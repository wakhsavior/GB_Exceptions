package Lection_03;

import java.io.FileWriter;
import java.io.IOException;

public class SaveService {
    public void save() throws IOException {
        try (FileWriter writer = new FileWriter("test")) {
            throw new IOException("operation failed");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
