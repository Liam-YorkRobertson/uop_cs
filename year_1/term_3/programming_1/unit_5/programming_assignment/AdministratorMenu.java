/**
 * Course Enrollment and Grade Management System
 *
 * Instructions to run program:
 * 1. Ensure Java is installed on your system.
 * 2. Save the file as `AdministratorMenu.java` and compile it with:
 *    javac AdministratorMenu.java
 * 3. Run the program using:
 *    java AdministratorMenu
 *
 * Usage:
 * - The main menu will prompt the administrator to select an option (add course, enroll student, assign grades,
 *   calculate overall grades, or exit).
 * - Follow the prompts to input data or choose from available options.
 * - Use appropriate input to avoid errors.
 */

import java.util.*;

/*
 * represents a student with a name, ID, and a list of enrolled courses.
 * includes methods for adding courses and managing student data.
 */
class Student {
    // stores student name
    private String studentName;
    // stores student ID
    private int studentID;
    // list of courses student is enrolled in
    private ArrayList<Course> enrolledCourses;
    // stores grades for each course
    private HashMap<Course, String> studentGrades;

    // constructor to initialise student
    public Student(String studentName, int studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.enrolledCourses = new ArrayList<>();
        this.studentGrades = new HashMap<>();
    }

    // gets student name
    public String getStudentName() {
        return studentName;
    }

    // sets student name
    public void setStudentName(String newStudentName) {
        studentName = newStudentName;
    }

    // gets student ID
    public int getStudentID() {
        return studentID;
    }

    // sets student ID
    public void setStudentID(int newStudentID) {
        studentID = newStudentID;
    }

    // gets list of enrolled courses
    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    // enrolls student in a course
    public void enrollStudents(Course newCourse) {
        enrolledCourses.add(newCourse);
    }

    // assigns grade for course
    public void assignGrades(Course courseGraded, String grade) {
        studentGrades.put(courseGraded, grade);
    }
}

/*
 * represents a course with a name, code, and a list of enrolled students.
 * includes methods to manage course details and student enrollments.
 */
class Course {
    // stores course code
    private int courseCode;
    // stores course name
    private String courseName;
    // stores maximum capacity of the course
    private int courseMaxCap = 500;
    // stores total number of enrolled students
    private static int enrolledStudents = 0;

    // constructor to initialise course
    public Course(int courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    // gets course code
    public int getCourseCode() {
        return courseCode;
    }

    // gets course name
    public String getCourseName() {
        return courseName;
    }

    // gets course maximum capacity
    public int getCourseMaxCap() {
        return courseMaxCap;
    }

    // enrolls a student in the course if not at max capacity
    public void enrollStudent() {
        if (enrolledStudents < courseMaxCap) {
            enrolledStudents++;
        } else {
            System.out.println("\nmax cap reached");
        }
    }

    // total number of enrolled students
    public static int totalEnrolledStudents() {
        return enrolledStudents;
    }
}

/*
 * manages courses and students.
 * includes methods for adding courses, enrolling students, assigning grades,
 * and calculating overall grades.
 */
class CourseManagement {
    // stores list of courses
    private static ArrayList<Course> listOfCourses = new ArrayList<>();
    // stores list of students
    private static ArrayList<Student> studentsList = new ArrayList<>();
    // stores overall course grades for students
    static HashMap<Student, HashMap<Course, String>> overallCourseGrades = new HashMap<>();
    
    // gets list of courses
    public static ArrayList<Course> getListOfCourses() {
        return listOfCourses;
    }

    // gets list of students
    public static ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    // adds course to list of courses
    public static void addCourse(String courseName, int courseCode) {
        Course newCourse = new Course(courseCode, courseName);
        listOfCourses.add(newCourse);
    }

    // enrolls student in a course
    public static void enrollStudent(Student studentToEnroll, Course courseToEnroll) {
        courseToEnroll.enrollStudent();
        studentToEnroll.enrollStudents(courseToEnroll);
        studentsList.add(studentToEnroll);
        overallCourseGrades.putIfAbsent(studentToEnroll, new HashMap<>());
    }

    // assigns grade for a course to student
    public static void assignGrade(Student studentToGrade, Course courseToGrade, String grade) {
        grade = grade.toUpperCase();
        overallCourseGrades.putIfAbsent(studentToGrade, new HashMap<>());
        studentToGrade.assignGrades(courseToGrade, grade);
        overallCourseGrades.get(studentToGrade).put(courseToGrade, grade);
    }

    // calculates overall grade for a student
    public static void calculateOverallGrade(Student studentOverallGrade) {
        // gets grades for specified student
        HashMap<Course, String> grades = overallCourseGrades.get(studentOverallGrade);
        
        if (grades == null || grades.isEmpty()) {
            System.out.println("No grades available for " + studentOverallGrade.getStudentName());
            return;
        }
    
        double totalGrades = 0;
        int gradeCount = 0;
    
        // processes each grade and adds value
        for (String grade : grades.values()) {
            switch (grade) {
                case "A+" -> totalGrades += 4.0;
                case "A" -> totalGrades += 4.0;
                case "A-" -> totalGrades += 3.7;
                case "B+" -> totalGrades += 3.3;
                case "B" -> totalGrades += 3.0;
                case "B-" -> totalGrades += 2.7;
                case "C+" -> totalGrades += 2.3;
                case "C" -> totalGrades += 2.0;
                case "C-" -> totalGrades += 1.7;
                case "D+" -> totalGrades += 1.3;
                case "D" -> totalGrades += 1.0;
                case "D-" -> totalGrades += 0.7;
                case "F" -> totalGrades += 0.0;
                default -> {
                    System.out.println("Invalid grade: " + grade);
                    continue;
                }
            }
            gradeCount++;
        }
    
        // calculates and prints average grade if any grades exist
        if (gradeCount > 0) {
            double averageGrade = totalGrades / gradeCount;
            String gradeSymbol = getGradeSymbol(averageGrade);
            System.out.println("\nOverall grade for " + studentOverallGrade.getStudentName() + " (ID: " 
                                + studentOverallGrade.getStudentID() + ") is " + averageGrade + " (" + gradeSymbol + ")");
        } else {
            System.out.println("No grades available for " + studentOverallGrade.getStudentName());
        }
    }

    // gets grade symbol from average grade
    private static String getGradeSymbol(double averageGrade) {
        if (averageGrade >= 4.0) return "A";
        if (averageGrade >= 3.7) return "A-";
        if (averageGrade >= 3.3) return "B+";
        if (averageGrade >= 3.0) return "B";
        if (averageGrade >= 2.7) return "B-";
        if (averageGrade >= 2.3) return "C+";
        if (averageGrade >= 2.0) return "C";
        if (averageGrade >= 1.7) return "C-";
        if (averageGrade >= 1.3) return "D+";
        if (averageGrade >= 1.0) return "D";
        if (averageGrade >= 0.7) return "D-";
        return "F";
    }
}

/*
 * This class handles the main menu for administrators.
 * It provides options to add courses, enroll students, assign grades, 
 * and calculate overall course grades.
 */
public class AdministratorMenu {
    // main for running the administrator menu system
    public static void main(String[] args) {
        // initialise user choice
        int userChoice;
        // scanner for input
        Scanner scanner = new Scanner(System.in);

        // display welcome message
        System.out.println("Welcome to the Course Enrollment and Grade Management System");

        // start menu loop
        do {
            // display menu options
            System.out.println("\n-------------------------------------------\n");
            System.out.println("What would you like to do:\n");
            System.out.println("1. Add new course");
            System.out.println("2. Enroll student in a course");
            System.out.println("3. Assign grades to students");
            System.out.println("4. Calculate overall course grades");
            System.out.println("5. Exit program\n");
            System.out.println("Insert choice:");

            // handle menu input with exception handling
            try {
                userChoice = Integer.parseInt(scanner.nextLine());
                switch (userChoice) {
                    // add a new course
                    case 1 -> {
                        System.out.println("\nEnter course name and code:");
                        String input = scanner.nextLine();
                        String[] courseDetails = input.split(" ");
                        String courseName = courseDetails[0];
                        int courseCode = Integer.parseInt(courseDetails[1]);

                        // check if course already exists
                        boolean courseExists = false;
                        for (Course course : CourseManagement.getListOfCourses()) {
                            if (course.getCourseName().equals(courseName) && course.getCourseCode() == courseCode) {
                                courseExists = true;
                                break;
                            }
                        }
                        if (courseExists) {
                            System.out.println("Course already exists.");
                        } else {
                            CourseManagement.addCourse(courseName, courseCode);
                            System.out.println("\nAdded new course: " + courseName + " " + courseCode);
                        }
                    }
                    // enroll student in course
                    case 2 -> { 
                        System.out.println("Enter student name:");
                        String studentName = scanner.nextLine();
                        System.out.println("Enter student ID:");
                        int studentID = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter course name and code:");
                        String input = scanner.nextLine();
                        String[] courseDetails = input.split(" ");
                        String courseName = courseDetails[0];
                        int courseCode = Integer.parseInt(courseDetails[1]);

                        // find course and student
                        Course selectedCourse = null;
                        for (Course course : CourseManagement.getListOfCourses()) {
                            if (course.getCourseName().equals(courseName) && course.getCourseCode() == courseCode) {
                                selectedCourse = course;
                                break;
                            }
                        }
                        Student selectedStudent = null;
                        for (Student student : CourseManagement.getStudentsList()) {
                            if (student.getStudentName().equals(studentName) && student.getStudentID() == studentID) {
                                selectedStudent = student;
                                break;
                            }
                        }
                        // create student if not exists
                        if (selectedStudent == null) {
                            selectedStudent = new Student(studentName, studentID);
                            CourseManagement.getStudentsList().add(selectedStudent);
                        }
                        // enroll if course found
                        if (selectedCourse != null) {
                            if (selectedStudent.getEnrolledCourses().contains(selectedCourse)) {
                                System.out.println("\n" + studentName + " is already enrolled.");
                            } else {
                                CourseManagement.enrollStudent(selectedStudent, selectedCourse);
                                System.out.println("\nEnrolled student in course: " + courseName + " " + courseCode);
                            }
                        } else {
                            System.out.println("Course not found.");
                        }
                    }
                    // assign grades to students
                    case 3 -> { 
                        System.out.println("Enter student name:");
                        String studentName = scanner.nextLine();
                        System.out.println("Enter student ID:");
                        int studentID = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter course name and code:");
                        String input = scanner.nextLine();
                        String[] courseDetails = input.split(" ");
                        String courseName = courseDetails[0];
                        int courseCode = Integer.parseInt(courseDetails[1]);
                        System.out.println("Enter grade:");
                        String grade = scanner.nextLine();

                        // find course and student
                        Course selectedCourse = null;
                        for (Course course : CourseManagement.getListOfCourses()) {
                            if (course.getCourseName().equals(courseName) && course.getCourseCode() == courseCode) {
                                selectedCourse = course;
                                break;
                            }
                        }
                        Student selectedStudent = null;
                        for (Student student : CourseManagement.getStudentsList()) {
                            if (student.getStudentName().equals(studentName) && student.getStudentID() == studentID) {
                                selectedStudent = student;
                                break;
                            }
                        }
                        // assign grade if both found
                        if (selectedCourse != null && selectedStudent != null) {
                            CourseManagement.assignGrade(selectedStudent, selectedCourse, grade);
                            System.out.println("\nAssigned grade: " + grade + " to " + studentName);
                        } else {
                            System.out.println("Course or student not found.");
                        }
                    }
                    // calculate overall course grades
                    case 4 -> { 
                        System.out.println("Enter student name:");
                        String studentName = scanner.nextLine();
                        System.out.println("Enter student ID:");
                        int studentID = Integer.parseInt(scanner.nextLine());

                        // find student to calculate grade
                        Student selectedStudent = null;
                        for (Student student : CourseManagement.getStudentsList()) {
                            if (student.getStudentName().equals(studentName) && student.getStudentID() == studentID) {
                                selectedStudent = student;
                                break;
                            }
                        }
                        if (selectedStudent != null) {
                            CourseManagement.calculateOverallGrade(selectedStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                    }
                    // exit program
                    case 5 -> { 
                        System.out.println("Thank you for using the system!");
                        System.exit(0);
                    }
                    // handle invalid input
                    default -> { 
                        System.out.println("Invalid choice");
                    }
                }
            // handle number format exceptions
            } catch (NumberFormatException e) { 
                System.out.println("Invalid input.");
            }
        // continue loop
        } while (true); 
    }
}
