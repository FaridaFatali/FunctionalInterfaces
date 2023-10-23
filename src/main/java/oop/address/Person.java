package oop.address;

public class Person {
    private final String no;
    private final String name;
    private Address address;

    public Person(String no, String name, Address address) {
        this.no = no;
        this.name = name;
        this.address = address;
    }

    public String getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // If we can't change something in objects we create new one and set these changes there
    public Address getAddress() {
        Address newAddress = new Address(address);
        return newAddress;
    }
}
