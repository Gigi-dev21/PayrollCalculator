package org.example;

import java.io.BufferedReader;
import java.io.FileReader;

class Employee {
    int employeeId;
    String name;
    double hoursWorked;
    double payRate;

    Employee(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.hoursWorked = hoursWorked;
        this.name = name;
        this.payRate = payRate;
    }

    // Getters
    public int getEmployeeId() {
        return this.employeeId;
    }

    public String getName() {
        return this.name;
    }

    public double getGrossPay() {
        return this.hoursWorked * this.payRate;
    }

    // Setter
    public void setId(int id) {
        this.employeeId = id;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("employes.csv"));

            // Skip header line
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|");

                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                double hours = Double.parseDouble(fields[2]);
                double rate = Double.parseDouble(fields[3]);

                Employee e = new Employee(id, name, hours, rate);

                // Display using printf and method calls
                System.out.printf("ID: %d\tName: %-20s\tGross Pay: $%.2f\n",
                        e.getEmployeeId(), e.getName(), e.getGrossPay());
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
