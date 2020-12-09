package lesson7;

public class Plate {
    private int food = 0;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
            food -= amount;
    }

    public void setFood(int amount){
        food += amount;
    }


    public void info() {
        System.out.println("Осталось еды: " + food);
    }
}
