package programming_assignment;

// class representing an employee
public class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    // constructor to initialise employee details
    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    // getter for name
    public String getName() {
        return name;
    }

    // setter for name
    public void setName(String name){
        this.name = name;
    }

    // getter for age
    public int getAge() {
        return age;
    }

    // setter for age
    public void setAge(int age){
        this.age = age;
    }

    // getter for department
    public String getDepartment() {
        return department;
    }

    // setter for department
    public void setDepartment(String department){
        this.department = department;
    }

    // getter for salary
    public double getSalary() {
        return salary;
    }

    // setter for salary
    public void setSalary(double salary){
        this.salary = salary;
    }
}