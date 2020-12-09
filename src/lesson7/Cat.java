package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean wellFed;

    public Cat(String name, int appetite, boolean wellFed) {
        this.name = name;
        this.appetite = appetite;
        this.wellFed = wellFed;
    }

    public String getName() {
        return name;
    }

    public int getAppetite(){
        return appetite;
    }

    public void eat(Plate plate) {
        System.out.println("Кот " + name + " поел и наелся.");
        plate.decreaseFood(appetite);
        wellFed = true;

    }

    public boolean getWellFed (){
        return wellFed;
    }






}
