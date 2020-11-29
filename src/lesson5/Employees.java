package lesson5;

public class Employees {
    private final String name;
    private final String position;
    private final String e_mail;
    private final String tel;
    int salary;
    int age;

    public Employees (String name, String position, String e_mail,
            String tel, int salary, int age) {
        this.name = name;
        this.position = position;
        this.e_mail = e_mail;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
    }

   public void info(){
        System.out.printf("%15s | %10s | %25s | %10s | %10s | %10s\n", name, position, e_mail, tel, salary, age);
    }



}
