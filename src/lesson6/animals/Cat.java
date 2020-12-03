package lesson6.animals;

public class Cat extends Animals {

    public Cat(String name) {
        this(name, 0, 200);
    }

    public Cat(String name, int swimLimit, int runLimit) {
        super(name);
        this.swimLimit = swimLimit;
        this.runLimit = runLimit;
    }

}
