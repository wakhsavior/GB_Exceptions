package Seminar_03_HW;

/**
 * Создает класс даты в формате dd.mm.yyyy
 */
public class Date {
    private int year;
    private int month;
    private int day;

    public Date(String date) throws DateException{
        String[] dateStrings = date.split("\\.");
        int[] dateInt;
        if (dateStrings.length != 3) {
            throw new DateException("Некорректный формат даты", date);
        }
        dateInt = new int[dateStrings.length];
        try {
            for (int i = 0; i < dateStrings.length; i++) {
                dateInt[i] = Integer.parseInt(dateStrings[i]);
            }

        } catch (NumberFormatException e) {
            throw new DateException("Данные в дате не соответствую численному типу int.", date);
        } catch (Exception e) {
            throw new DateException("С форматом даты что-то не так.", date);
        }
        if (dateInt[0] < 1 || dateInt[0] > 31) {
            throw new DateException("Число находится в недопустимом диапазоне от 1 до 31", date);
        } else {
            this.day = dateInt[0];
        }
        if (dateInt[1] < 1 || dateInt[1] > 12) {
            throw new DateException("Номер месяца находится в недопустимом диапазоне от 1 до 12", date);
        } else {
            this.month = dateInt[1];
        }
        if (dateInt[2] < 1900 || dateInt[2] > 2023) {
            throw new DateException("Значение года находится в недопустимом диапазоне от 1900 до 2023", date);
        } else {
            this.year = dateInt[2];
        }
    }

    @Override
    public String toString() {
        return String.format("%d.%d.%d", this.day, this.month, this.year);
    }
}
