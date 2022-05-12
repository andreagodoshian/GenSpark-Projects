package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student implements Person {

    private int id;
    private String name;

    @Autowired
    public Phone phone;

    @Autowired
    public Address address;

    public int getId() {
        return id;
    }

    @Value("1")
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Value("John Doe Jr.")
    public void setName(String name) {
        this.name = name;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void info() {
        System.out.println("Role: " + this.getClass().getSimpleName() +
                "\nID: " + id +
                "\nName: " + name +
                "\nPhone: " + phone +
                "\nAddress: " + address);
    }
}
