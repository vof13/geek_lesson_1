package lesson4;


import java.util.Random;
import java.util.Scanner;

    public class Main {
        static final int SIZE = 4;
        static final int DOTS_TO_WIN = 3;

        static final char DOT_X = 'X';
        static final char DOT_O = 'O';
        static final char DOT_EMPTY = '.';

        static char[][] map;

        static Scanner sc = new Scanner(System.in);
        static Random random = new Random();


        public static void main(String[] args) {
            System.out.println("Играем до "+DOTS_TO_WIN+" совпадений");
            initMap();
            printMap();

            while (true) {
                humanTurn();
                printMap();
                if (checkWin(DOT_X)) {
                    System.out.println("Вы выиграли!!!");
                    break;
                }
                if (isFull()) {
                    System.out.println("Ничья");
                    break;
                }

                aiTurn();
                printMap();
                if (checkWin(DOT_O)) {
                    System.out.println("Комьютер победил");
                    break;
                }
                if (isFull()) {
                    System.out.println("Ничья");
                    break;
                }
            }
        }

        static void initMap() {
            map = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        static void printMap() {
            System.out.print("  ");
            for (int i = 0; i < SIZE; i++) {
                System.out.print(i + 1 + " ");
            }
            System.out.println();
            for (int i = 0; i < SIZE; i++) {
                System.out.print(i + 1 + " ");
                for (int j = 0; j < SIZE; j++) {
                    System.out.printf("%c ", map[i][j]);
                }
                System.out.println();
            }
        }

        static void humanTurn() {
            int x;
            int y;
            do {
                System.out.println("Введите координаты X Y");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } while (!isCellValid(y, x));
            map[y][x] = DOT_X;
        }

        static void aiTurn() {
            int x;
            int y;
            if (!atackDefence(DOT_O)) {
                if (!atackDefence(DOT_X)) {
                    do {
                        x = random.nextInt(SIZE);
                        y = random.nextInt(SIZE);
                    } while (!isCellValid(y, x));
                    map[y][x] = DOT_O;
                }
            }
        }

        static boolean atackDefence (char c){
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map [i][j] == DOT_EMPTY) {
                        map [i][j] = c;
                        if (checkWin(c)) {
                            map[i][j] = DOT_O;
                            return true;
                        } else map [i][j] = DOT_EMPTY;
                    }
                }
            }
            return false;
        }

        static boolean isCellValid(int y, int x) {
            if (y < 0 || x < 0 || y >= SIZE || x >= SIZE || map[y][x] == DOT_O || map[y][x] == DOT_X) {
                System.out.println("Вы ввели неверные координаты.");
                return false;
            }
            return map[y][x] == DOT_EMPTY;
        }

        static boolean isFull() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_EMPTY) {
                        return false;
                    }
                }
            }
            return true;
        }

        static boolean checkWin(char c) {
            int rows;
            int columns;
            int diag;

            for (int i = 0; i < SIZE; i++) {
                rows = 0; columns = 0; diag = 0;
                for (int j = 0; j < SIZE; j++) {

                    // проверка выигранной комбинации в строке
                    if (map[i][j] == c) {
                        rows ++;
                        if (rows == DOTS_TO_WIN){
                            return true;
                        }
                    } else rows = 0;

                    // проверка выигранной комбинации в столбце
                    if (map[j][i] == c) {
                        columns++;
                        if (columns == DOTS_TO_WIN){
                            return true;
                        }
                    } else columns = 0;

                    //проверка 1-й диагонали
                    if ((i + DOTS_TO_WIN) <= SIZE && (j + DOTS_TO_WIN) <= SIZE) {
                        for (int k = 0; k < DOTS_TO_WIN; k++) {
                            if (map[i+k][j+k] == c) {
                                diag++;
                                if (diag == DOTS_TO_WIN){
                                    return true;
                                }
                            } else {
                                diag = 0;
                                break;
                            }
                        }
                    }

                    // проверка 2-й диагонали
                    if ((i - (DOTS_TO_WIN - 1)) >= 0 && (j + DOTS_TO_WIN) <= SIZE) {
                        for (int k = 0; k < DOTS_TO_WIN; k++) {
                            if (map[i-k][j+k] == c) {
                                diag++;
                                if (diag == DOTS_TO_WIN){
                                    return true;
                                }
                            } else {
                                diag = 0;
                                break;
                            }

                        }
                    }
                }
            }
            return false;
        }
    }
