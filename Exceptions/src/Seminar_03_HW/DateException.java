package Seminar_03_HW;

public class DateException extends RuntimeException{
    private String date;

    public String getString() {
        return date;
    }

    public DateException(String message, String date) {
        super(message);
        this.date = date;
    }
}
