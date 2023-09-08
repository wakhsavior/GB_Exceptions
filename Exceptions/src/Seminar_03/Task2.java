package Seminar_03;


/*
Демонстрация работы Autoclosable. Имплементируем интерфейс autoclosable и переопределяем метод close.
 */
public class Task2 {
    public static void main(String[] args) {
        try (Counter counter1 = new Counter(20)) {
            counter1.add();
            counter1.add();
            counter1.add();
            counter1.add();
            System.out.printf("Текущее значение счетчика: %d\n", counter1.getCounter());
            counter1.closeCounter();
            counter1.add();
        } catch (CloseCounterException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

class Counter implements AutoCloseable {
    private int counter;

    public int getCounter() {
        return counter;
    }

    private boolean isOpen;

    public int add() throws CloseCounterException {
        if (!isOpen) {
            throw new CloseCounterException("Счетчик закрыт.");
        }
        return ++counter;
    }

    { // Инициализатор, выполняется каждый раз при вызове конструктора
        isOpen = true;
    }

    public Counter() {

    }

    public Counter(int counter) {
        this.counter = counter;
    }

    public void closeCounter() {
        isOpen = false;
    }

    @Override
    public void close() throws Exception {
        closeCounter();
    }
}

class CloseCounterException extends Exception {
    public CloseCounterException(String message) {
        super(message);
    }
}