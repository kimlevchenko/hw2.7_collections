package pro.sky.java.group.hwcollections.model;

import java.util.Objects;

public class Employee {

    private final String fistName;
    private final String lastName;

    public Employee(String fistName, String lastName) {
        this.fistName = fistName;
        this.lastName = lastName;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fistName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(fistName, employee.fistName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fistName, lastName);
    }
}
