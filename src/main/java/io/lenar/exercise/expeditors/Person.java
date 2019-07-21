package io.lenar.exercise.expeditors;

import java.util.Comparator;

public class Person implements Comparable<Person> {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String address;

    public Person(String line) {
        String[] fields = line.split("\",\"");

        this.firstName = clearAndClean(fields[0]);
        this.lastName = clearAndClean(fields[1]);
        this.age = Integer.parseInt(clearAndClean(fields[5]));
        this.address = clearAndClean(fields[2]) + ", " + clearAndClean(fields[3]) + ", " + clearAndClean(fields[4]);
    }

    private String clearAndClean(String str) {
        return str
                .replaceAll("\"", "")
                .replaceAll(",", "")
                .replaceAll("\\.", "")
                .trim()
                .toUpperCase();
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public String toString() {
        return lastName + " " + firstName + ", " + address + ", " + age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int compareTo(Person person) {
        return Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName).compare(this, person);
    }
}
