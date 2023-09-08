package Seminar_03;

import java.awt.*;
import java.util.Random;

/**
 * Есть иерархия животных, постараемся сделать его подходящим к использованию в разных местах
 * Нет никакого вывода, только исключения
 */
public class Task3 {
    public static void main(String[] args) {

        try {
            Animal cat = new Cat("Персик");
            Random rnd = new Random();
            for (int i = 0; i < 10; i++) {
                int j = rnd.nextInt(2);
                try {
                    switch (j) {
                        case 0 -> cat.swim(i * 10);
                        case 1 -> {
                            cat.run(i * 10);
                            System.out.println("Кот успешно пробежал дистанцию.");
                        }
                    }
                } catch (AnimalSwimException e) {
                    System.out.printf("Исключение при попытке %s проплыть %d метров.\n", e.getName(), e.getDistance());
                } catch (AnimalRunException e) {
                    System.out.printf("Исключение при попытке %s пробежать %d метров.\n", e.getName(), e.getDistance());
                }
            }
        } catch (AnimalNameException e) {
            System.out.println(e.getName());
        }
    }
}

abstract class Animal {
    String name;

    public Animal(String name) throws AnimalNameException {
        if (name == null || name.length() < 3)
            throw new AnimalNameException("Некорректное имя животного", name);
        this.name = name;
    }

    abstract void swim(int distance) throws AnimalSwimException;

    abstract void run(int distance) throws AnimalRunException;
}

class Cat extends Animal {
    public Cat(String name) throws AnimalNameException {
        super(name);
    }

    @Override
    void swim(int distance) throws AnimalSwimException {
        throw new AnimalSwimException("Кот не умеет плавать.", name, distance);
    }

    @Override
    void run(int distance) throws AnimalRunException {
        if (distance < 50) {
            //TODO

        } else {
            throw new AnimalRunException("Коту тяжело бежать", name, distance);
        }

    }
}

abstract class AnimalException extends Exception {
    public AnimalException(String message) {
        super(message);
    }
}

abstract class AnimalActionException extends AnimalNameException {
    private final int distance;

    public AnimalActionException(String message, String name, int distance) {
        super(message, name);
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}

class AnimalRunException extends AnimalActionException {
    public AnimalRunException(String message, String name, int distance) {
        super(message, name, distance);
    }
}

class AnimalSwimException extends AnimalActionException {
    public AnimalSwimException(String message, String name, int distance) {
        super(message, name, distance);
    }
}

class AnimalNameException extends AnimalException {
    private String name;

    public AnimalNameException(String message, String name) {
        super(message);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}