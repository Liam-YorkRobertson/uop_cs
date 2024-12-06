/**
 * Student Record Management System
 *
 * Instructions to run program:
 * 1. Ensure Java is installed on your system
 * 2. Save the file as `StudentManagement.java` and compile it with:
 *    javac StudentManagement.java
 * 3. Run the program using:
 *    java StudentManagement
 *
 * Usage:
 * - The main menu will prompt the user to select an option (add, update, view, or exit).
 * - Follow the prompts to input data or choose from available options.
 * - Use appropriate input to prevent errors.
 */
import java.util.*;

public class StudentManagement {
    // stores name of student
    private String studentName;
    // stores ID of student
    private int studentID;
    // stores age of student
    private int studentAge;
    // stores grade of student
    private String studentGrade;
    // static map to hold student database with student name as key and array of details as value
    private static Map<String, Object[]> studentDatabase = new HashMap<>();

    public static void main(String[] args) {
        int userDemand; // stores user's menu choice
        StudentManagement obj = new StudentManagement(); // creates instance of StudentManagement
        Scanner s = new Scanner(System.in); // single scanner instance for reuse
        System.out.println("Welcome to Student Record Management System");
        do {
            // displays main menu
            System.out.println("\n-------------------------------------------\n");
            System.out.println("What would you like to do:\n");
            System.out.println("1. Add new student to database");
            System.out.println("2. Update student information");
            System.out.println("3. View student details");
            System.out.println("4. Exit program\n");
            System.out.println("Insert choice:");
            try {
                userDemand = Integer.parseInt(s.nextLine()); // reads user input for menu choice
                switch (userDemand) {
                    case 1 -> {
                        obj.add_student(); // calls method to add new student
                    }
                    case 2 -> {
                        update_student(); // calls method to update student information
                    }
                    case 3 -> {
                        // displays options for viewing student details
                        System.out.println("\nWould you like to:");
                        System.out.println("1. View list of students");
                        System.out.println("2. View number of students in database");
                        System.out.println("\nInsert choice:");
                        try {
                            int userDemand2 = Integer.parseInt(s.nextLine()); // reads user input for sub-menu choice
                            switch (userDemand2) {
                                case 1 -> {
                                    student_list(); // calls method to display list of all students
                                }
                                case 2 -> {
                                    student_total(); // calls method to display total number of students
                                }
                                default -> {
                                    System.out.println("Incorrect input");
                                    System.exit(0); // exits program if invalid input provided
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                        }
                    }
                    case 4 -> {
                        System.out.println("\nThank you for using the Student Record Management System!");
                        System.exit(0); // exits program
                    }
                    default -> {
                        System.out.println("Incorrect input");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        } while (true); // repeats menu until user chooses to exit
    }

    // method to add new student to database
    public void add_student() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("\nPlease insert student's name: ");
            studentName = s.nextLine(); // reads student's name
            System.out.println("Please insert student's identification number: ");
            studentID = Integer.parseInt(s.nextLine()); // reads student's ID with error handling
            System.out.println("Please insert student's age: ");
            studentAge = Integer.parseInt(s.nextLine()); // reads student's age with error handling
            System.out.println("Please insert student's grade: ");
            studentGrade = s.nextLine(); // reads student's grade
            // stores student details in database
            studentDatabase.put(studentName, new Object[]{studentID, studentAge, studentGrade});
            System.out.println("Student added to database successfully");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number for ID and age.");
        }
    }

    // method to update student information
    public static void update_student() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("\nInsert name of student whose details you would like to update:");
            String studentUpdate = s.nextLine(); // reads name of student to update
            if (studentDatabase.containsKey(studentUpdate)) {
                System.out.println("\nWhat would you like to modify:");
                System.out.println("1. Name");
                System.out.println("2. Identification document");
                System.out.println("3. Age");
                System.out.println("4. Grade");
                System.out.println("5. Remove student");
                System.out.println("\nInsert choice:");
                int userDemand3 = Integer.parseInt(s.nextLine()); // reads user input for type of update
                switch (userDemand3) {
                    case 1 -> {
                        // updates student's name
                        System.out.println("Insert new name of student:");
                        String newStudentName = s.nextLine();
                        Object[] tempStudent = studentDatabase.get(studentUpdate);
                        studentDatabase.remove(studentUpdate);
                        studentDatabase.put(newStudentName, tempStudent);
                        System.out.println("\nName changed successfully");
                    }
                    case 2 -> {
                        // updates student's ID
                        System.out.println("Insert new ID of student:");
                        int newStudentID = Integer.parseInt(s.nextLine()); // reads new ID with error handling
                        Object[] studentDetails = studentDatabase.get(studentUpdate);
                        studentDetails[0] = newStudentID;
                        System.out.println("\nID changed successfully");
                    }
                    case 3 -> {
                        // updates student's age
                        System.out.println("Insert new age of student:");
                        int newStudentAge = Integer.parseInt(s.nextLine()); // reads new age with error handling
                        Object[] studentDetails = studentDatabase.get(studentUpdate);
                        studentDetails[1] = newStudentAge;
                        System.out.println("\nAge changed successfully");
                    }
                    case 4 -> {
                        // updates student's grade
                        System.out.println("Insert new grade of student:");
                        String newStudentGrade = s.nextLine();
                        Object[] studentDetails = studentDatabase.get(studentUpdate);
                        studentDetails[2] = newStudentGrade;
                        System.out.println("\nGrade changed successfully");
                    }
                    case 5 -> {
                        // removes student from database
                        System.out.println("\nAre you sure you would like to remove this student? Yes/No");
                        String userDemand4 = s.nextLine();
                        switch (userDemand4) {
                            case "Yes", "yes" -> {
                                studentDatabase.remove(studentUpdate);
                                System.out.println("\nStudent removed successfully");
                            }
                            case "No", "no" -> {
                                System.out.println("\nStudent was not removed.");
                            }
                            default -> {
                                System.out.println("Incorrect input");
                                System.exit(0); // exits program if invalid input provided
                            }
                        }
                    }
                    default -> {
                        System.out.println("Incorrect input");
                        System.exit(0); // exits program if invalid input provided
                    }
                }
            } else {
                System.out.println("Student does not exist");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    // method to display total number of students in database
    public static void student_total() {
        System.out.println("\nTotal number of students in database: " + studentDatabase.size());
    }

    // method to display list of all students in database
    public static void student_list() {
        System.out.println();
        for (Map.Entry<String, Object[]> entry : studentDatabase.entrySet()) {
            String studentName = entry.getKey();
            Object[] studentDetails = entry.getValue();
            // prints student details including name, ID, age, and grade
            System.out.println("Student: " + studentName + " - ID: " + studentDetails[0] + ", Age: "
            + studentDetails[1] + ", Grade: " + studentDetails[2]);
        }
    }
}
