package com.pluralsight.hotelOperations;

public class Employee {
    private String employeeID;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double shiftTime;

    public Employee(String employeeID, String name, String department, double payRate, double hoursWorked, double shiftTime) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.shiftTime= -1;
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

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getRegularHours(){
        return Math.min(hoursWorked,40);

    }

    public double getOverTimeHours(){
        return Math.max(0,hoursWorked-40);
    }

    public double getTotalPay(){
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

    public void punchTimeCard(double time){
        if (shiftTime== -1){ //Employee punch in
            shiftTime=time;
            System.out.println(name + "Shift start at " + time + " hours");
        } else { // employee punch out
            double shiftHours = time-shiftTime;

            if (shiftHours<0){
                System.out.println("Error, Your punch-out time cannot be earlier than your punch-in time");
                return;
            }
            setHoursWorked(getHoursWorked()+shiftHours);

            System.out.println("Shift end at " +time + " hours." + "Worked " + shiftHours + "hours this shift" );

            shiftTime=-1;
        }
    }
}
