package ua.hillel.task5;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee(
                "Иванов Иван Иванович",
                "Менеджер",
                "ivanofff@gmail.com",
                "0631234567",
                29);
        System.out.printf("ФИО: %s%n", employee.getFullName());
        System.out.printf("Должность: %s%n", employee.getPosition());
        System.out.printf("Email: %s%n", employee.getEmail());
        System.out.printf("Телефон: %s%n", employee.getPhoneNumber());
        System.out.printf("Возраст: %d%n", employee.getAge());

        Car car = new Car();
        car.start();
    }
}
