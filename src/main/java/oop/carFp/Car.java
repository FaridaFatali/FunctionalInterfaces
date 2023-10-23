package oop.carFp;

public class Car {
    private final String make;
    private final String model;
    private final String year;
    private int speed;
    private int distance;

    public Car(String make, String model, String year, int speed, int distance) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.speed = speed;
        this.distance = distance;
    }

    public void go(int newDistance) {
        distance += newDistance;
    }

    public void accelerate(int speed) {
        System.out.println("Speeding up to " + speed);
        this.speed = speed;
    }

    public void stop() {
        System.out.println("Stopping");
        speed = 0;
    }

    public String getInfo() {
        return "Car Info: " + year + " " + make + " " + model + ". Distance: " + distance + " km. and traveling at " + speed + " kmph.";
    }
}
