package com.ubs.pojos;

public class Employee {

    private String employeeFirstName;
    private String employeeLastName;
    private long employeeId;



    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public long getEmployeeId() {

        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public Employee() {
    }
    public Employee(String employeeFirstName, String employeeLastName, long employeeId) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeId = employeeId;
    }
    @Override
    public String toString() {
        return "employee{" +
                "employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }
}
