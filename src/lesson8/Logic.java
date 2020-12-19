package lesson8;


import java.util.Random;


public class Logic {
    static int SIZE;
    static int DOTS_TO_WIN;
    static int firstWinX;
    static int firstWinY;
    static int secondWinX;
    static int secondWinY;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';


    static char[][] map;

    static boolean gameFinished;
    static String answer;

    static Random random = new Random();

    static char dotNext;


    public static void go(int mode) {

        gameFinished = true;

        printMap();

        if (checkWin(dotNext) && mode == 1 && SettingWindow.firstPlayerSymbol != dotNext) {
            answer = "1st player WIN!!!";
            System.out.println(answer);
            return;}
        else if (checkWin(dotNext) && mode == 1 && SettingWindow.firstPlayerSymbol == dotNext) {
            answer = "2st player WIN!!!";
            System.out.println(answer);
            return;}
        else if (checkWin(dotNext) && mode == 0){
            answer = "You WIN!!!";
            System.out.println(answer);
            return;
        }
        if (isFull()) {
            answer = "Draw.";
            System.out.println(answer);
            return;
        }

        if (mode == 0){
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                answer = "Ai win  :(";
                System.out.println(answer);
                return;
            }
            if (isFull()) {
                answer = "Draw.";
                System.out.println(answer);
                return;
            }
        }
        gameFinished = false;
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

    static void humanTurn(int x, int y, int mode) {
        if (isCellValid(y, x)) {
            if (mode == 1 && dotNext == 'X') {
            dotNext = 'O';
        } else if (mode == 1 && dotNext =='O') {
            dotNext = 'X';
        } else dotNext = 'X';

            map[y][x] = dotNext;
            go(mode);
        }

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
                        secondWinX = (j+1)*BattleMap.cellWidth;
                        secondWinY = i*BattleMap.cellHeight+BattleMap.cellWidth/2;
                        firstWinX = secondWinX - (DOTS_TO_WIN)*BattleMap.cellWidth;
                        firstWinY = secondWinY;
                        return true;
                    }
                } else rows = 0;

                // проверка выигранной комбинации в столбце
                if (map[j][i] == c) {
                    columns++;
                    if (columns == DOTS_TO_WIN){
                        secondWinX = i*BattleMap.cellWidth + BattleMap.cellWidth/2;
                        secondWinY = (j+1)*BattleMap.cellHeight;
                        firstWinX = secondWinX;
                        firstWinY = secondWinY - (DOTS_TO_WIN)*BattleMap.cellHeight;
                        return true;
                    }
                } else columns = 0;

                //проверка 1-й диагонали
                if ((i + DOTS_TO_WIN) <= SIZE && (j + DOTS_TO_WIN) <= SIZE) {
                    for (int k = 0; k < DOTS_TO_WIN; k++) {
                        if (map[i+k][j+k] == c) {
                            diag++;
                            if (diag == DOTS_TO_WIN){
                                secondWinX = (j+k+1)*BattleMap.cellWidth;
                                secondWinY = (i+k+1)*BattleMap.cellHeight;
                                firstWinX = (j + k - DOTS_TO_WIN+1)*BattleMap.cellWidth;
                                firstWinY = (i + k - DOTS_TO_WIN+1)*BattleMap.cellHeight;
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
                                secondWinX = (j+k+1)*BattleMap.cellWidth;
                                secondWinY = (i-k)*BattleMap.cellHeight;
                                firstWinX = (j + k - DOTS_TO_WIN + 1)*BattleMap.cellWidth;
                                firstWinY = (i - k + DOTS_TO_WIN)*BattleMap.cellHeight;
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
