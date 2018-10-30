package com.serionz.communityhealthproject.model;

import java.util.UUID;

/**
 * Created by johns on 30/10/2018.
 */
public class Child {
    private String uuid;
    private String firstName;
    private String lastName;
    private int age;
    private int weight;

    public Child(String firstName, String lastName, int age, int weight) {
        this.uuid = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.weight = weight;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Child{" +
                "uuid='" + uuid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
