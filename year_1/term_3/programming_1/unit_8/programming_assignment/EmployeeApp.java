/**
 * Employee Details Review System
 *
 * Instructions to run the program:
 * 1. Ensure Java is installed on your system.
 * 2. Save the file as `EmployeeApp.java` and compile it with:
 * 3. ensure you have the other files: EmployeeDataset.java and Employee.java in the same directory
 * 4. compile all the files with the following command:
 *      javac EmployeeApp.java EmployeeDataset.java Employee.java
 * 5. go the parent directory of the files and run the program with the following command:
 *      java directory_name.EmployeeApp
 *
 * Usage:
 * - The main menu will allow users to choose between different Employee Details functionality.
 * - Users can view a list of employees and their respective departments.
 * - Users can calculate the average salary of employees.
 * - Users can filter employees by age.
 * - Users can view the employee with the minimum or maximum salary.
 * - Ensure that input formats are correct when providing data.
 * - The system prints details and provides feedback when the information is processed successfully.
 **/

package programming_assignment;
import java.util.*;
import java.util.function.Function; 
import java.util.stream.Collectors;

// main class for the Employee Details Review System
public class EmployeeApp {
    public static void main(String[] args) {
        EmployeeDataset dataset = new EmployeeDataset(); // dataset containing employee information
        List<Employee> employees = dataset.employees; // list of employees
        Scanner scanner = new Scanner(System.in); // scanner for user input

        while (true) {
            System.out.println("\n-----------------------------------------------\n");
            System.out.println("Welcome to the Employee Details Review System\n");
            System.out.println("Select one of the following options:\n");
            System.out.println("1. View employees' names and departments");
            System.out.println("2. Calculate the average salary");
            System.out.println("3. Filter employees by age");
            System.out.println("4. View minimum and maximum salaries");
            System.out.println("5. Exit the program\n");
            System.out.print("Enter your choice: ");

            try {
                int userChoice = Integer.parseInt(scanner.nextLine());
                switch (userChoice){
                    case 1 -> {
                        // option to view employees' names and departments
                        System.out.println();
                        printEmployeeDetails(employees);
                    }
                    case 2 -> {
                        // option to calculate the average salary
                        double averageSalary = calculateAverageSalary(employees);
                        System.out.println("\nAverage salary of employees: " + averageSalary);
                    }
                    case 3 -> {
                        // option to filter employees by age
                        System.out.println("\nDo you want to filter employees below or above a certain threshold:\n");
                        System.out.println("1. Below");
                        System.out.println("2. Above");
                        System.out.println("3. Exit\n");
                        System.out.print("Enter your choice: ");
                        int userChoice2 = Integer.parseInt(scanner.nextLine());
                        switch (userChoice2) {
                            case 1 -> {
                                // filter employees below a certain age
                                String threshold = "below";
                                System.out.print("\nEnter the age threshold: ");
                                int age = Integer.parseInt(scanner.nextLine());
                                System.out.println();
                                filterEmployees(employees, threshold, age);
                            }
                            case 2 -> {
                                // filter employees above a certain age
                                String threshold = "above";
                                System.out.print("\nEnter the age threshold: ");
                                int age = Integer.parseInt(scanner.nextLine());
                                System.out.println();
                                filterEmployees(employees, threshold, age);
                            }
                            case 3 -> {
                                // exit the program
                                System.out.println("Exiting the program...");
                                System.exit(0);
                            }
                            default -> {
                                // invalid choice for age filter
                                System.out.println("Invalid choice. Please try again.");
                            }
                        }
                    }
                    case 4 -> {
                        // option to view minimum or maximum salaries
                        System.out.println("\nDo you want to view the employee with the minimum or maximum salary:\n");
                        System.out.println("1. Minimum");
                        System.out.println("2. Maximum");
                        System.out.println("3. Exit\n");
                        System.out.print("Enter your choice: ");
                        int userChoice3 = Integer.parseInt(scanner.nextLine());
                        switch (userChoice3) {
                            case 1 -> {
                                // view employee with minimum salary
                                String minOrMax = "minimum";
                                System.out.println();
                                minMaxSalaries(employees, minOrMax);
                            }
                            case 2 -> {
                                // view employee with maximum salary
                                String minOrMax = "maximum";
                                System.out.println();
                                minMaxSalaries(employees, minOrMax);
                            }
                            case 3 -> {
                                // exit the program
                                System.out.println("Exiting the program...");
                                System.exit(0);
                            }
                            default -> {
                                // invalid choice for salary view
                                System.out.println("Invalid choice. Please try again.");
                            }
                        }
                    }
                    case 5 -> {
                        // exit the program
                        System.out.println("Exiting the program...");
                        scanner.close();
                        System.exit(0);
                    }
                    default -> {
                        // invalid main menu choice
                        System.out.println("Invalid choice. Please try again.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    // method to print employee details (name and department) using stream
    public static void printEmployeeDetails(List<Employee> employees) {
        // function to get employee name and department
        Function<Employee, String> nameAndDepartment = (e) -> {
            return "Name: " + e.getName() + "  |  Department: " + e.getDepartment();
        };

        // create new collection using stream and print employee details
        List<String> employeeDetails = employees.stream()
                .map(nameAndDepartment)
                .collect(Collectors.toList());

        // print employee details
        for (String employee : employeeDetails) {
            System.out.println(employee);
        };
    }
    
    // method to calculate the average salary of employees
    public static double calculateAverageSalary(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    // method to filter employees by age
    public static void filterEmployees(List<Employee> employees, String threshold, int age) {
        // filter employees by age
        List<Employee> filteredEmployees = new ArrayList<>();
        if (threshold.equals("below")) {
            filteredEmployees = employees.stream()
                .filter(e -> e.getAge() < age)
                .sorted(Comparator.comparingInt(Employee::getAge))
                .collect(Collectors.toList()); 
        } else if (threshold.equals("above")) {
            filteredEmployees = employees.stream()
                .filter(e -> e.getAge() > age)
                .sorted(Comparator.comparingInt(Employee::getAge))
                .collect(Collectors.toList());
        }
        // print filtered employees
        for (Employee employee : filteredEmployees) {
            System.out.println("Name: " + employee.getName() + "  |  Age " + employee.getAge()
            + "  |  Department: " + employee.getDepartment() + "  |  Salary: " + employee.getSalary());
        }
    }

    // method to find and print employee with minimum or maximum salary
    public static void minMaxSalaries(List<Employee> employees, String minOrMax) {
        Employee employeeSalaries = null;
        if (minOrMax.equals("minimum")) {
            employeeSalaries = employees.stream()
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
            System.out.println(employeeSalaries.getName() + "(" + employeeSalaries.getAge() + ") " +
            "in the " + employeeSalaries.getDepartment() + " department has the lowest salary of " +
            employeeSalaries.getSalary());
        } else if (minOrMax.equals("maximum")) {
            employeeSalaries = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
                System.out.println(employeeSalaries.getName() + "(" + employeeSalaries.getAge() + ") " +
                "in the " + employeeSalaries.getDepartment() + " department has the highest salary of " +
                employeeSalaries.getSalary());
        }
    }
}