
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