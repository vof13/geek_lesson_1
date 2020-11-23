package lesson3;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {
        System.out.println("Игра: угадай число от 1 до 9");
        findNumber ();
        System.out.println("\nИгра: угадай слово");
        findWord();

    }

    public static void findWord(){
        String[] arr = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "\n",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "\n",
                "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Мы загадали одно слово из этого списка: " + Arrays.toString(arr));
        int i = random.nextInt(arr.length);
//        System.out.println("Мы загадали слово: " + arr[i]);
        do {
            System.out.println("Напишите слово: ");
            String userWord = sc.next();
            if (userWord.equals(arr[i])) {
                System.out.println("Вы угадали!!!");
                break;
            } else {
                compair(arr[i], userWord);
            }
        } while (true);

    }

    public static void compair (String findWord, String userWord){
        StringBuilder sbUserWord = new StringBuilder();
        StringBuilder  sbUnswer = new StringBuilder();
        StringBuilder sbFindWord = new StringBuilder();
        byte guessedLetter = 0;
        sbUnswer.append("###############");
        sbFindWord.append(findWord);
        sbUserWord.append(userWord);
        int quantity = Math.min(sbFindWord.length(), sbUserWord.length());
        for (int i = 0; i < quantity ; i++) {
            if (sbUserWord.charAt(i) == sbFindWord.charAt(i)) {
                sbUnswer.setCharAt(i, sbUserWord.charAt(i));
                guessedLetter++;
            }
        }
        if (guessedLetter == 0) {
            System.out.println("Совпадений нет");
        } else {
            System.out.println("Вы угадали некоторые буквы: " + sbUnswer);
        }
    }


    public static void findNumber (){
        int isRepeat, userNum;
        do {
            int hiddenNum = random.nextInt(9) + 1;
//            System.out.println("Загаданное число : " + hiddenNum);
            for (int i = 0; i < 3; i++) {
                System.out.println(i+1 + "-я попытка. Введите число:");
                userNum = sc.nextInt();
                if (userNum > hiddenNum) {
                    System.out.println("Ваше число больше, чем загаданное\n");
                } else if (userNum < hiddenNum){
                    System.out.println("Ваше число меньше загаданного\n");
                } else {System.out.println("Вы угадали!!!");
                    break;}
                if (i == 2) {
                    System.out.println("Вы не угадали за 3 попытки.\nМы загадали число: " + hiddenNum);
                }
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            isRepeat = sc.nextByte();
        } while ( isRepeat == 1 );



    }




}
