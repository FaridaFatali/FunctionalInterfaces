package oop.car;

public class DriverTest {
    public static void main(String[] args) {
        Car car1 = new Car("Mercedes", "C200", "2017", 0, 0);
        Driver driver = new Driver("Joseph", car1);
        Place losAngeles = new Place("Los Angeles", 400);
        driver.drive(losAngeles);

        System.out.println();

        Car car2 = new Car("BMW", "i8", "2018", 10000, 16);
        driver.setCar(car2);
        Place newYork = new Place("New York", 155);
        driver.drive(newYork);
    }
}
