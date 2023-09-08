package Seminar_03_HW;

public class InputDateException extends RuntimeException{
    private String string;
    public InputDateException(String message, String string) {
        super(message);
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
