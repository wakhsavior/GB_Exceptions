package Lection_03;

import java.io.FileWriter;
import java.io.IOException;

public class SaveService_v2 {
    public void save() throws SavedException {
        try (FileWriter writer = new FileWriter("test")) {
            throw new IOException("operation failed");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new SavedException("Saved documents failed",e);
        }
    }
}
