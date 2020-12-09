package lesson7;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte eating;

        System.out.println("Введите количество котов: ");
        int catCount = sc.nextInt();
        Cat[] cat = new Cat [catCount];

//   создаем котов и не даем ввести отрицательный аппетит

        for (int i = 0; i < catCount; i++) {
            System.out.println("Введите имя " + (i+1) + " кота: ");
            sc.nextLine();
            String name = sc.nextLine();
            int appetite;
            do {
                System.out.println("Введите аппетит " + name);
                appetite = sc.nextInt();
                cat [i] = new Cat(name, appetite, false);
            } while (appetite <= 0);
        }

        Plate plate = new Plate(0);
        do {
            System.out.println("Насыпайте еду в миску: ");
            plate.setFood(sc.nextInt());


            //   отправляем каждого кота есть

            for (int i = 0; i < catCount; i++) {
                if ((plate.getFood() >= cat [i].getAppetite()) && !(cat[i].getWellFed())){
                    cat[i].eat(plate);
                }
            }
            plate.info();
            System.out.println("Будем кормить котов? 1-ДА / 2-НЕТ");
            eating = sc.nextByte();
        } while (eating == 1);

        plate.info();

    }

}

