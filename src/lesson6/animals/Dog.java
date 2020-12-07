package lesson6.animals;

public class Dog extends Animals {

    public Dog (String name) {
        this(name, 10, 500);
    }

    public Dog (String name, int swimLimit, int runLimit) {
        super(name);
        this.swimLimit = swimLimit;
        this.runLimit = runLimit;
    }
}

