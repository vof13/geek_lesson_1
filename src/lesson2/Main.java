
package lesson2;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static     Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Задача 1 'О замене 0 на 1 и обратно': ");
        oneToZero();
        System.out.println("Задача 2 'О автоматическом заполнении массива': ");
        autoIns();
        System.out.println("Задача 3 'О умножении чисел меньше 6 на 2': ");
        lessSix();
        System.out.println("Задача 4 'О замене диагоналей в двумерном массиве': ");
        squareArr();
        System.out.println("Задача 5 'О поиске макс и мин': ");
        findMaxMin();
        System.out.println("Задача 6 'О сумме левой и правой части': ");
        System.out.println("Ответ: " + findCenter() + "\n");
        System.out.println("Задача 7 'О перемещению чисел': ");
        displace();
    }

    //    метод замены 0 на 1 и обратно
    public static void oneToZero(){
        int[] arr = {0,1,0,1,1,1,0,0,0};
        System.out.println("Первоначальный массив:" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {arr[i] = 0; }
        }
        System.out.println("Измененный массив: " + Arrays.toString(arr) + "\n");
    }

    // метод автоматического заполнения массива
    public static void autoIns(){
        int [] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i*3;
        }
        System.out.println("Заполненный массив: " + Arrays.toString(arr) + "\n");

    }
    // метод умножения чисел меньше 6 на 2
    public static void lessSix(){
        int [] arr = genArr(10);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println("Измененный массив: " + Arrays.toString(arr) + "\n");
    }
    // метод замены диагоналей в двумерном массиве на 1
    public static void squareArr() {
        int[][] arr = new int [7][7] ;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                arr [i][j] = random.nextInt(8) + 2;
            }
        }
        System.out.println("Сгенерированный массив: ");
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == j || i + j == 6){
                    arr [i][j] = 1;
                }
            }
        }
        System.out.println("Новый массив: ");
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();

    }

    // метод нахождения максимума и мимнимума
    static public void findMaxMin() {
        int[] arr = genArr(100);    //вызов метода для генерации одномерного массива
        int max =arr[0] , min = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr [i+1] < min) {
                min = arr[i+1];
            }
            if (arr[i+1] > max) {
                max = arr[i+1];
            }
        }
        System.out.printf("Минимальное число = %d. Максимальное число = %d\n\n", min, max);
    }

    // метод сравнения суммы левой и правой стороны
    static public boolean findCenter(){
        int[] arr = genArr(3);
        int i = 0, j = arr.length-1;
        int sumL = arr[i], sumR = arr[j];
        while (i<j-1) {
            if (sumL > sumR){
                sumR += arr[j-1];
                j--;
            } else {
                sumL += arr[i+1];
                i++;
            }
        }
        return sumL == sumR;
    }
    //метод перемещения массива
    public static void displace (){
        int[] arr = genArr(10);
        System.out.println("Введите число для перемещения");
        int n = sc.nextInt();
        if (n < 0)
        {n = arr.length + n;}
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                int x = arr[j];
                arr[j] = arr[arr.length - 1];
                arr[arr.length - 1] = x;
            }
        }
        System.out.println("Перемещенный массив: " + Arrays.toString(arr));
    }

    //метод генератора массива псевдослучайных чисел
    public static int[] genArr (int k){
        System.out.println("Сгенерированный массив: ");
        int[] arr = new int[10] ;
        for (int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(k);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

}