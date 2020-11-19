package lesson2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static     Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Задача 1:");
        oneToZero();
        System.out.println("Задача 2: ");
        autoIns();
        System.out.println("Задача 3: ");
        lessSix();
        System.out.println("Задача 4: ");
        squareArr();


//        System.out.println("Задача по перемещению чисел.");
//        System.out.println("Введите число для перемещения");
//
//        int n = sc.nextInt();
//        displace(n);

    }

    public static void oneToZero(){
        int[] arr = {0,1,0,1,1,1,0,0,0};
        System.out.println("Первоначальный массив:" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {arr[i] = 0; }
        }
        System.out.println("Измененный массив: " + Arrays.toString(arr));
    }

    public static void autoIns(){
        int [] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i*3;
        }
        System.out.println("Заполненный массив: " + Arrays.toString(arr));

    }

    public static void lessSix(){
        int [] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Первоначальный массив:" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println("Измененный массив: " + Arrays.toString(arr));
    }

    public static void squareArr() {
        int[][] arr = new int [7][7] ;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                arr [i][j] = random.nextInt(8) + 2;
            }
        }
        System.out.println("Сгенерированный массив: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == j || i + j == 6){
                    arr [i][j] = 1;
                }
            }
        }
        System.out.println("Новый массив: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }

//        int [][] arr = {
//                {2, 6, 9, 5, 3},
//                {1, 9, 3, 7, 4},
//                {},
//                {},
//                {},
//        };

//    public static void displace (int n){
//        int[] arr = {2,4,6,8,10};
//        System.out.println("Первоначальный массив:" + Arrays.toString(arr));
//        if (n < 0)
//        {n = arr.length + n;}
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < arr.length - 1; j++) {
//                int x = arr[j];
//                arr[j] = arr[arr.length - 1];
//                arr[arr.length - 1] = x;
//            }
//        }
//        System.out.println("Перемещенный массив: " + Arrays.toString(arr));
//
//    }
}
