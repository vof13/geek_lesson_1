package lesson1;

public class MainClass {
    public static void main(String[] args) {
        byte b = 5;
        short s = 100;
        int i = 1000;
        long l = 100000L;
        float f = 0.151151f;
        double d = 151515.151;
        char ch = 'G';
        boolean bool = true;

        System.out.println("Задание 3: " + math (0.2f, 1.5f, 2.5f, 3.5f));
        System.out.println("Задание 4: " + compair (10,11));
        System.out.print("Задание 5: ");
        isPositive(5);
        System.out.println("Задание 6: " + isPositiveBool(5));
        System.out.print("Задание 7:");
        name("Володя");
    }

    public static float math (float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean compair (int a, int b){
        return  10 <= a+b && a+b <= 20;
    }

    public static void isPositive (int a){
        if (a >= 0) {
            System.out.println("Число положительное или равно нулю");
        } else {
            System.out.println("Число отрицательное");}
    }

    public static boolean isPositiveBool (int a){
        return a < 0;
    }

    public static void name (String nam){
        System.out.println("Привет, " + nam + "!");
    }



    }
