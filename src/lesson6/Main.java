package lesson6;

import lesson6.animals.Animals;
import lesson6.animals.Cat;
import lesson6.animals.Dog;


public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat ("Барсик");
        Dog dog = new Dog ("Бобик");

        cat.setSwim (1);
        cat.setRun (200);

        dog.setSwim (9);
        dog.setRun (400);

        System.out.println("Создано животных: " + Animals.k);

    }
}