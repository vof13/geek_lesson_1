package lesson5;

public class Main {
    public static void main(String[] args) {
        Employees[] employees = new Employees[5];
        employees[0] = new Employees("Ivanov Ivan", "Engineer", "ivivan@mailbox.com",
                "892312312", 30000, 45);
        employees[1] = new Employees("Petrov Petr", "Mechanic", "petrov@mailbox.com",
                "8901010101", 25000, 32);
        employees[2] = new Employees("Sidorov Pavel", "Driver", "petrov@mailbox.com",
                "895656565", 40000, 35);
        employees[3] = new Employees("Latushkin Dima", "Worker", "latushkin@mailbox.com",
                "8947474747", 20000, 41);
        employees[4] = new Employees("Putilo Vasja", "Director", "putilo@mailbox.com",
                "892222222", 60000, 50);
        System.out.printf("%15s | %10s | %25s | %10s | %10s | %10s\n", "name", "position", "e_mail",
                "tel", "salary", "age");
        for (Employees employee : employees) {
            if (employee.age > 40)
                employee.info();
        }
    }
}
