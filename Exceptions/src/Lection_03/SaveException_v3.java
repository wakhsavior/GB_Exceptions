package Lection_03;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class SaveException_v3 extends IOException{
    private Date startDate;

    public SaveException_v3(String message, Date startDate,Exception e) {
        super(message);
        this.startDate = startDate;
    }

    public void save() throws SavedException {
        try (FileWriter writer = new FileWriter("test")) {
            throw new IOException("operation failed");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new SavedException("Saved documents failed",e);
        }
    }
}
