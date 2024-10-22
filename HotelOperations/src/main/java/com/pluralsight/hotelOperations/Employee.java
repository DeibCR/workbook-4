package com.pluralsight.hotelOperations;

public class Employee {
    private String employeeID;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    public Employee(String employeeID, String name, String department, double payRate, double hoursWorked) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getRegularHours(){
        return Math.min(hoursWorked,40);

    }

    public double getOverTimeHours(){
        return Math.max(0,hoursWorked-40);
    }

    public double getTotalpay(){
        double totalPay;
        if (hoursWorked <=40){
            totalPay= payRate * hoursWorked;

        }else {
            double regularPay = payRate*40;
            double overTimePay= getOverTimeHours() * payRate * 1.5;
            totalPay= regularPay + overTimePay;

        }
        return totalPay;
    }
}
