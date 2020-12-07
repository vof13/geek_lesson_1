package lesson6.animals;

public class Animals {
    String name;
    int swimLimit;
    int runLimit;


    public static int k=0;

    public Animals(String name) {
        this.name = name;
        k++;
    }

    public void setSwim(int dist){
        if (dist <= swimLimit){

            System.out.println(name + " проплыл " + dist + " метров.");
        } else {
            System.out.println(name + " не проплывет " + dist + " метров");
        }
    }

    public void setRun(int dist) {
        if (dist <= runLimit) {
            System.out.println(name + " пробежал " + dist + " метров.");
        } else {
            System.out.println(name + " не пробежит " + dist + " метров");
        }
    }



}
