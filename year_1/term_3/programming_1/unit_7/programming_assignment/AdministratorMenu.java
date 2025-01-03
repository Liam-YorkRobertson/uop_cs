/**
 * Student Management System with GUI
 *
 * Instructions to run the program:
 * 1. Ensure Java is installed on your system.
 * 2. Save the file as `AdministratorMenu.java` and compile it with:
 *    javac AdministratorMenu.java
 * 3. Run the program using:
 *    java AdministratorMenu
 *
 * Usage:
 * - The main menu will allow users to choose between student management, course management, and grade management.
 * - In student management, users can add, update, and view student information.
 * - In course management, users can enroll students into courses.
 * - In grade management, users can add grades for students and view student grades.
 * - Ensure that input formats are correct when typing in textfields.
 * - The system saves details and provides feedback when the information is saved successfully.
 **/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AdministratorMenu implements ActionListener{
    // main window frame
    private JFrame window;
    // buttons for different management sections
    private JButton studentManButton, courseManButton, gradeManButton;

    public AdministratorMenu() {
        // initialise window
        window = new JFrame();
        // welcome label
        JLabel welcomeLabel = new JLabel("Welcome to the Student Management System", SwingConstants.CENTER);
        // instruction label
        JLabel basicInstrLabel = new JLabel("Which of the following operations would you like to perform:", SwingConstants.CENTER);
        // student management button
        studentManButton = new JButton("Student Management");
        studentManButton.addActionListener(this);
        // course management button
        courseManButton = new JButton("Course Management");
        courseManButton.addActionListener(this);
        // grade management button
        gradeManButton = new JButton("Grade Management");
        gradeManButton.addActionListener(this);
        // panel for layout
        JPanel content = new JPanel();
        content.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));
        content.setLayout(new GridLayout(0, 1, 10, 10));
        content.add(welcomeLabel);
        content.add(basicInstrLabel);
        content.add(studentManButton);
        content.add(courseManButton);
        content.add(gradeManButton);
        // add panel to window
        window.add(content);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Student Management System");
        window.setSize(1800, 1800);
        window.pack();  
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    public static void main(String args[]) {
        new AdministratorMenu(); 
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            // handle button clicks
            if (event.getSource() == studentManButton) {
                window.dispose();
                new StudentManagement();
            } else if (event.getSource() == courseManButton) {
                window.dispose();
                new CourseManagement();
            } else if (event.getSource() == gradeManButton) {
                window.dispose();
                new GradeManagement();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(window, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

// class for student management window
class StudentManagement implements ActionListener {
    private JFrame smWindow;
    private JButton returnButton, addStudentButton, updateStudentButton, viewStudentButton;
    static ArrayList<String[]> studentData = new ArrayList<>();

    public StudentManagement() {
        // initialise window
        smWindow = new JFrame();
        // welcome label
        JLabel welcomeLabel = new JLabel("Student Management", SwingConstants.CENTER);
        // instruction label
        JLabel basicInstrLabel = new JLabel("Which of the following operations would you like to perform:", SwingConstants.CENTER);
        // add student button
        addStudentButton = new JButton("Add Student");
        addStudentButton.addActionListener(this);
        // update student button
        updateStudentButton = new JButton("Update Student");
        updateStudentButton.addActionListener(this);
        // view student button
        viewStudentButton = new JButton("View Student");
        viewStudentButton.addActionListener(this);
        // return to main menu button
        returnButton = new JButton("Return to Main Menu");
        returnButton.addActionListener(this);
        // panel for layout
        JPanel smContent = new JPanel();
        smContent.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));
        smContent.setLayout(new GridLayout(0, 1, 10, 10));
        smContent.add(welcomeLabel);
        smContent.add(basicInstrLabel);
        smContent.add(addStudentButton);
        smContent.add(updateStudentButton);
        smContent.add(viewStudentButton);
        smContent.add(returnButton);
        // add panel to window
        smWindow.add(smContent);
        smWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        smWindow.setTitle("Student Management");
        smWindow.setSize(1800, 1800);
        smWindow.pack();
        smWindow.setLocationRelativeTo(null);
        smWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            // handle button clicks
            if (event.getSource() == returnButton) {
                smWindow.dispose();
                new AdministratorMenu();
            } else if (event.getSource() == addStudentButton) {
                smWindow.dispose();
                new AddStudent();
            } else if (event.getSource() == updateStudentButton) {
                smWindow.dispose();
                new UpdateStudent();
            } else if (event.getSource() == viewStudentButton) {
                smWindow.dispose();
                new ViewStudent();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(smWindow, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

// class for adding a student
class AddStudent implements ActionListener {
    JFrame asWindow;
    JButton returnButton, submitButton;
    JTextField studentNameField, studentAgeField, studentIDField;

    public AddStudent() {
        // initialise window
        asWindow = new JFrame();
        // welcome label
        JLabel asWelcomeLabel = new JLabel("Student Addition", SwingConstants.CENTER);
        // instruction label
        JLabel asBasicInstrLabel = new JLabel("Please insert student details in the following fields:", SwingConstants.CENTER);
        // student name label and field
        JLabel nameLabel = new JLabel("Student name: ", SwingConstants.LEFT);
        nameLabel.setBounds(10, 10, 100, 30);
        studentNameField = new JTextField(50);
        studentNameField.setBounds(10, 50, 200, 30);
        // student age label and field
        JLabel ageLabel = new JLabel("Student age: ", SwingConstants.LEFT);
        ageLabel.setBounds(10, 90, 100, 30);
        studentAgeField = new JTextField(50);
        studentAgeField.setBounds(10, 130, 200, 30);
        // student ID label and field
        JLabel idLabel = new JLabel("Student ID: ", SwingConstants.LEFT);
        idLabel.setBounds(10, 170, 100, 30);
        studentIDField = new JTextField(50);
        studentIDField.setBounds(10, 210, 200, 30);
        // submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        // return button
        returnButton = new JButton("Return to Student Managment");
        returnButton.addActionListener(this);
        // panel for layout
        JPanel asContent = new JPanel();
        asContent.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));
        asContent.setLayout(new GridLayout(0, 1, 10, 10));
        asContent.add(asWelcomeLabel);
        asContent.add(asBasicInstrLabel);
        asContent.add(nameLabel);
        asContent.add(studentNameField);
        asContent.add(ageLabel);
        asContent.add(studentAgeField);
        asContent.add(idLabel);
        asContent.add(studentIDField);
        asContent.add(submitButton);
        asContent.add(returnButton);    
        // add panel to window
        asWindow.add(asContent);
        asWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        asWindow.setTitle("Student Management");
        asWindow.setSize(1800, 1800);
        asWindow.pack();
        asWindow.setLocationRelativeTo(null);
        asWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            // handle button clicks
            if (event.getSource() == submitButton) {
                String name = studentNameField.getText().trim();
                String age = studentAgeField.getText().trim();
                String id = studentIDField.getText().trim();
                if (name.isEmpty() || age.isEmpty() || id.isEmpty()) {
                    JOptionPane.showMessageDialog(asWindow, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    StudentManagement.studentData.add(new String[]{name, age, id});
                    JOptionPane.showMessageDialog(asWindow, "Student added successfully!", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                    studentNameField.setText("");
                    studentAgeField.setText("");
                    studentIDField.setText("");
                }
            } else if (event.getSource() == returnButton) {
                asWindow.dispose();
                new StudentManagement();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(asWindow, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

// class for updating a student
class UpdateStudent implements ActionListener {
    JFrame usWindow;
    JButton returnButton, checkButton, removeButton, submitButton;
    JTextField studentNameField, studentAgeField, studentIDField;

    public UpdateStudent() {
        // initialise window
        usWindow = new JFrame();
        // welcome label
        JLabel usWelcomeLabel = new JLabel("Update Student Details", SwingConstants.CENTER);
        // instruction label
        JLabel usBasicInstrLabel = new JLabel("Please insert student details in the following fields:", SwingConstants.CENTER);
        // student name label and field
        JLabel nameLabel = new JLabel("Insert the name of the student whose information you would like to update: ",
        SwingConstants.LEFT);
        nameLabel.setBounds(10, 10, 100, 30);
        studentNameField = new JTextField(50);
        checkButton = new JButton("Check if student exists");
        checkButton.addActionListener(this); 
        studentNameField.setBounds(10, 50, 200, 30);
        // student age label and field
        JLabel ageLabel = new JLabel("Student age: ", SwingConstants.LEFT);
        ageLabel.setBounds(10, 90, 100, 30);
        studentAgeField = new JTextField(50);
        studentAgeField.setBounds(10, 130, 200, 30);
        // student ID label and field
        JLabel idLabel = new JLabel("Student ID: ", SwingConstants.LEFT);
        idLabel.setBounds(10, 170, 100, 30);
        studentIDField = new JTextField(50);
        studentIDField.setBounds(10, 210, 200, 30);
        // remove student button
        removeButton = new JButton("Remove Student");
        removeButton.addActionListener(this);
        // submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        // return button
        returnButton = new JButton("Return to Student Managment");
        returnButton.addActionListener(this);
        // panel for layout
        JPanel usContent = new JPanel();
        usContent.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));
        usContent.setLayout(new GridLayout(0, 1, 10, 10));
        usContent.add(usWelcomeLabel);
        usContent.add(usBasicInstrLabel);
        usContent.add(nameLabel);
        usContent.add(studentNameField);
        usContent.add(checkButton);
        usContent.add(ageLabel);
        usContent.add(studentAgeField);
        usContent.add(idLabel);
        usContent.add(studentIDField);
        usContent.add(removeButton);
        usContent.add(submitButton);
        usContent.add(returnButton);
        // add panel to window
        usWindow.add(usContent);
        usWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        usWindow.setTitle("Student Management");
        usWindow.setSize(1800, 1800);
        usWindow.pack();
        usWindow.setLocationRelativeTo(null);
        usWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            // handle button clicks
            String name = studentNameField.getText().trim();
            if (event.getSource() == checkButton) {
                boolean exists = false;
                for (String[] student : StudentManagement.studentData) {
                    if (student[0].equalsIgnoreCase(name)) {
                        exists = true;
                        break;
                    }
                }
                JOptionPane.showMessageDialog(usWindow, exists ? "Student exists." : "Student does not exist.",
                exists ? "Student Found" : "Error", exists ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
                if (!exists) studentNameField.setText("");
            } else if (event.getSource() == submitButton) {
                try {
                    int age = Integer.parseInt(studentAgeField.getText().trim());
                    int id = Integer.parseInt(studentIDField.getText().trim());
                    boolean updated = false;
                    for (String[] student : StudentManagement.studentData) {
                        if (student[0].equalsIgnoreCase(name)) {
                            student[1] = Integer.toString(age);
                            student[2] = Integer.toString(id);
                            updated = true;
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(usWindow, updated ? "Student details updated." : "Student not found.",
                    "Result", JOptionPane.INFORMATION_MESSAGE);
                    studentNameField.setText("");
                    studentAgeField.setText("");
                    studentIDField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(usWindow, "Age and ID must be numbers!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                }
            } else if (event.getSource() == removeButton) {
                boolean removed = false;
                for (int i = 0; i < StudentManagement.studentData.size(); i++) {
                    if (StudentManagement.studentData.get(i)[0].equalsIgnoreCase(name)) {
                        StudentManagement.studentData.remove(i);
                        removed = true;
                        break;
                    }
                }
                JOptionPane.showMessageDialog(usWindow, removed ? "Student removed." : "Student not found.", "Result",
                JOptionPane.INFORMATION_MESSAGE);
                studentNameField.setText("");
                studentAgeField.setText("");
                studentIDField.setText("");
            } else if (event.getSource() == returnButton) {
                usWindow.dispose();
                new StudentManagement();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(usWindow, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

// class for viewing students
class ViewStudent implements ActionListener {
    JFrame vsWindow;
    JButton returnButton;

    public ViewStudent() {
        // initialise window
        vsWindow = new JFrame();
        // welcome label
        JLabel vsWelcomeLabel = new JLabel("View Student Details", SwingConstants.CENTER);
        // instruction label
        JLabel vsBasicInstrLabel = new JLabel("Details of Students: ", SwingConstants.CENTER);
        // get student data
        java.util.List<String[]> studentList = StudentManagement.studentData;
        String[][] data = new String[studentList.size()][3];
        for (int i = 0; i < studentList.size(); i++) {
            String[] student = studentList.get(i);
            data[i][0] = student[0];
            data[i][1] = student[1];
            data[i][2] = student[2];
        }
        // column names for table
        String[] columnNames = {"Student Name", "Student ID", "Student Age"};
        // create table
        JTable studentTable = new JTable(data, columnNames);
        studentTable.setPreferredScrollableViewportSize(new Dimension(400, 150));
        JScrollPane spStudentTable = new JScrollPane(studentTable);
        // return button
        returnButton = new JButton("Return");
        returnButton.addActionListener(this);
        // panel for layout
        JPanel vsContent = new JPanel();
        vsContent.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));
        vsContent.setLayout(new GridLayout(0, 1, 10, 10));
        vsContent.add(vsWelcomeLabel);
        vsContent.add(vsBasicInstrLabel);
        vsContent.add(spStudentTable);
        vsContent.add(returnButton);
        // add panel to window
        vsWindow.add(vsContent);
        vsWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vsWindow.setTitle("Student Management");
        vsWindow.setSize(600, 400);
        vsWindow.setLocationRelativeTo(null);
        vsWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            // handle button clicks
            if (event.getSource() == returnButton) {
                vsWindow.dispose();
                new StudentManagement();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vsWindow, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

// class for course management window
class CourseManagement implements ActionListener {
    JFrame cmWindow;
    JButton returnButton, confirmButton;
    JComboBox<String> studentComboBox, courseComboBox;
    static ArrayList<String[]> enrollments = new ArrayList<>();
    String[] courseList = {"Programming 1", "Programming 2", "Web Development 1", "Psychology 3", "Mathematics 2", 
                           "Mobile Development 2", "Cybersecurity 4", "English 2", "Machine Learning 1", "Statistics 2"};

    public CourseManagement() {
        // initialise window
        cmWindow = new JFrame();
        // welcome label
        JLabel welcomeLabel = new JLabel("Enroll Student", SwingConstants.CENTER);
        // instruction label
        JLabel basicInstrLabel = new JLabel("Select options from the menus to enroll a student into a specific course",
        SwingConstants.CENTER);
        // course label and combo box
        JLabel enrollCourse = new JLabel("Course:", SwingConstants.LEFT);
        enrollCourse.setBounds(10, 90, 100, 30);
        courseComboBox = new JComboBox<>(courseList);
        // student label and combo box
        JLabel enrollStudent = new JLabel("Student:", SwingConstants.LEFT);
        enrollStudent.setBounds(10, 10, 100, 30);
        ArrayList<String> availableStudents = getAvailableStudents();
        studentComboBox = new JComboBox<>(availableStudents.toArray(new String[0]));
        // confirmation label
        JLabel confirmDetails = new JLabel("Are you sure you want to enroll the student into the course?", SwingConstants.CENTER);
        confirmDetails.setBounds(10, 170, 100, 30);
        // confirm button
        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(this);
        // return button
        returnButton = new JButton("Return to Main Menu");
        returnButton.addActionListener(this);
        // panel for layout
        JPanel cmContent = new JPanel();
        cmContent.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));
        cmContent.setLayout(new GridLayout(0, 1, 10, 10));
        cmContent.add(welcomeLabel);
        cmContent.add(basicInstrLabel);
        cmContent.add(enrollCourse);
        cmContent.add(courseComboBox);
        cmContent.add(enrollStudent);
        cmContent.add(studentComboBox);
        cmContent.add(confirmDetails);
        cmContent.add(confirmButton);
        cmContent.add(returnButton);
        // add panel to window
        cmWindow.add(cmContent);
        cmWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cmWindow.setTitle("Course Management");
        cmWindow.setSize(1800, 1800);
        cmWindow.pack();
        cmWindow.setLocationRelativeTo(null);
        cmWindow.setVisible(true);
    }

    private ArrayList<String> getAvailableStudents() {
        ArrayList<String> availableStudents = new ArrayList<>();
        for (String[] student : StudentManagement.studentData) {
            String studentName = student[0];
            boolean isEnrolled = false;
            for (String[] enrollment : enrollments) {
                if (enrollment[0].equals(studentName)) {
                    isEnrolled = true;
                    break;
                }
            }
            if (!isEnrolled) {
                availableStudents.add(studentName);
            }
        }
        return availableStudents;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            // handle button clicks
            if (event.getSource() == confirmButton) {
                String selectedCourse = (String) courseComboBox.getSelectedItem();
                String selectedStudent = (String) studentComboBox.getSelectedItem();
                boolean isEnrolled = false;
                for (String[] enrollment : enrollments) {
                    if (enrollment[0].equals(selectedStudent) && enrollment[1].equals(selectedCourse)) {
                        isEnrolled = true;
                        break;
                    }
                }
                if (isEnrolled) {
                    JOptionPane.showMessageDialog(cmWindow, "Error: " + selectedStudent + " is already enrolled in " + selectedCourse,
                    "Enrollment Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    enrollments.add(new String[]{selectedStudent, selectedCourse});
                    JOptionPane.showMessageDialog(cmWindow, selectedStudent + " has been enrolled in " + selectedCourse);
                }
            } else if (event.getSource() == returnButton) {
                cmWindow.dispose();
                new AdministratorMenu();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(cmWindow, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

// class for grade management window
class GradeManagement implements ActionListener {
    private JFrame gmWindow;
    private JButton addGradeButton, viewGradeButton, returnButton;

    public GradeManagement() {
        // initialise window
        gmWindow = new JFrame();
        // welcome label
        JLabel welcomeLabel = new JLabel("Grade Management", SwingConstants.CENTER);
        // instruction label
        JLabel basicInstrLabel = new JLabel("Which of the following operations would you like to perform:", SwingConstants.CENTER);
        // add grade button
        addGradeButton = new JButton("Add Grade");
        addGradeButton.addActionListener(this);
        // view grade button
        viewGradeButton = new JButton("View Grade");
        viewGradeButton.addActionListener(this);
        // return to main menu button
        returnButton = new JButton("Return to Main Menu");
        returnButton.addActionListener(this);
        // panel for layout
        JPanel gmContent = new JPanel();
        gmContent.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));
        gmContent.setLayout(new GridLayout(0, 1, 10, 10));
        gmContent.add(welcomeLabel);
        gmContent.add(basicInstrLabel);
        gmContent.add(addGradeButton);
        gmContent.add(viewGradeButton);
        gmContent.add(returnButton);
        // add panel to window
        gmWindow.add(gmContent);
        gmWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gmWindow.setTitle("Grade Management");
        gmWindow.setSize(1800, 1800);
        gmWindow.pack();
        gmWindow.setLocationRelativeTo(null);
        gmWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            // handle button clicks
            if (event.getSource() == addGradeButton) {
                gmWindow.dispose();
                new AddGrade();
            } else if (event.getSource() == viewGradeButton) {
                gmWindow.dispose();
                new ViewGrades();
            } else if(event.getSource() == returnButton) {
                gmWindow.dispose();
                new AdministratorMenu();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(gmWindow, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

// class for adding a grade
class AddGrade implements ActionListener {
    JFrame agWindow;
    JButton returnButton, submitButton;
    JComboBox<String> studentComboBox, courseComboBox, gradeComboBox;
    static ArrayList<HashMap<String, String>> enrollmentGrades = new ArrayList<>();

    public AddGrade() {
        // initialise window
        agWindow = new JFrame();
        // welcome label
        JLabel welcomeLabel = new JLabel("Grade Addition", SwingConstants.CENTER);
        // instruction label
        JLabel basicInstrLabel = new JLabel("Please insert student details in the following fields:", SwingConstants.CENTER);
        // student name label and combo box
        JLabel nameLabel = new JLabel("Student name: ", SwingConstants.LEFT);
        nameLabel.setBounds(10, 10, 100, 30);
        studentComboBox = new JComboBox<>();
        ArrayList<String> availableStudents = new ArrayList<>();
        for (String[] student : StudentManagement.studentData) {
            String studentName = student[0];
            boolean isEnrolled = false;
            for (String[] enrollment : CourseManagement.enrollments) {
                if (enrollment[0].equals(studentName)) {
                    isEnrolled = true;
                    break;
                }
            }
            if (isEnrolled) {
                availableStudents.add(studentName);
            }
        }
        studentComboBox.setModel(new DefaultComboBoxModel<>(availableStudents.toArray(new String[0])));
        // course label and combo box
        JLabel courseLabel = new JLabel("Course: ", SwingConstants.LEFT);
        courseLabel.setBounds(10, 10, 100, 30);
        courseComboBox = new JComboBox<>();
        if (studentComboBox.getItemCount() > 0) {
            String selectedStudent = (String) studentComboBox.getSelectedItem();
            ArrayList<String> coursesForStudent = new ArrayList<>();
            for (String[] enrollment : CourseManagement.enrollments) {
                if (enrollment[0].equals(selectedStudent)) {
                    coursesForStudent.add(enrollment[1]);
                }
            }
            courseComboBox.setModel(new DefaultComboBoxModel<>(coursesForStudent.toArray(new String[0])));
        }
        // grade label and combo box
        JLabel gradeLabel = new JLabel("Grade:", SwingConstants.LEFT);
        gradeLabel.setBounds(10, 10, 100, 30);
        String[] gradeList = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"};
        gradeComboBox = new JComboBox<>(gradeList);
        // submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        // return button
        returnButton = new JButton("Return to Grade Management");
        returnButton.addActionListener(this);
        // panel for layout
        JPanel agContent = new JPanel();
        agContent.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));
        agContent.setLayout(new GridLayout(0, 1, 10, 10));
        agContent.add(welcomeLabel);
        agContent.add(basicInstrLabel);
        agContent.add(nameLabel);
        agContent.add(studentComboBox);
        agContent.add(courseLabel);
        agContent.add(courseComboBox);
        agContent.add(gradeLabel);
        agContent.add(gradeComboBox);
        agContent.add(submitButton);
        agContent.add(returnButton);
        // add panel to window
        agWindow.add(agContent);
        agWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        agWindow.setTitle("Grade Management");
        agWindow.setSize(1800, 1800);
        agWindow.pack();
        agWindow.setLocationRelativeTo(null);
        agWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            // handle button clicks
            if (event.getSource() == submitButton) {
                String selectedStudent = (String) studentComboBox.getSelectedItem();
                String selectedCourse = (String) courseComboBox.getSelectedItem();
                String selectedGrade = (String) gradeComboBox.getSelectedItem();
                boolean gradeAssigned = false;
                for (int i = 0; i < CourseManagement.enrollments.size(); i++) {
                    String[] enrollment = CourseManagement.enrollments.get(i);
                    if (enrollment[0].equals(selectedStudent) && enrollment[1].equals(selectedCourse)) {
                        HashMap<String, String> gradeEntry = new HashMap<>();
                        gradeEntry.put("student", selectedStudent);
                        gradeEntry.put("course", selectedCourse);
                        gradeEntry.put("grade", selectedGrade);
                        boolean entryUpdated = false;
                        for (HashMap<String, String> entry : enrollmentGrades) {
                            if (entry.get("student").equals(selectedStudent) && entry.get("course").equals(selectedCourse)) {
                                entry.put("grade", selectedGrade);
                                entryUpdated = true;
                                break;
                            }
                        }
                        if (!entryUpdated) {
                            enrollmentGrades.add(gradeEntry);
                        }
                        gradeAssigned = true;
                        break;
                    }
                }
                if (!gradeAssigned) {
                    HashMap<String, String> gradeEntry = new HashMap<>();
                    gradeEntry.put("student", selectedStudent);
                    gradeEntry.put("course", selectedCourse);
                    gradeEntry.put("grade", selectedGrade);
                    enrollmentGrades.add(gradeEntry);
                }
                JOptionPane.showMessageDialog(agWindow, "Grade " + selectedGrade + " has been assigned to " +
                        selectedStudent + " in " + selectedCourse);
            } else if (event.getSource() == returnButton) {
                agWindow.dispose();
                new GradeManagement();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(agWindow, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

// class for viewing grades
class ViewGrades implements ActionListener {
    JFrame vgWindow;
    JComboBox<String> studentComboBox;
    JTable gradeTable;
    JButton returnButton;
    String[] columnNames = {"Course", "Grade"};
    String[][] tableData = new String[0][2];
    AddGrade addGrade;

    public ViewGrades() {
        // initialise window
        vgWindow = new JFrame("View Student Grades");
        // get student list
        ArrayList<String> studentList = new ArrayList<>();
        for (String[] enrollment : CourseManagement.enrollments) {
            if (!studentList.contains(enrollment[0])) {
                studentList.add(enrollment[0]);
            }
        }
        studentList.add(0, "Select student...");
        String[] studentNames = studentList.toArray(new String[0]);
        // student combo box
        studentComboBox = new JComboBox<>(studentNames);
        studentComboBox.addActionListener(this);
        addGrade = new AddGrade();
        // grade table
        gradeTable = new JTable(tableData, columnNames);
        JScrollPane tableScrollPane = new JScrollPane(gradeTable);
        // return button
        returnButton = new JButton("Return");
        returnButton.addActionListener(this);
        // panel for layout
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));
        panel.add(new JLabel("View Student Grades", SwingConstants.CENTER));
        panel.add(new JLabel("Student:"));
        panel.add(studentComboBox);
        panel.add(tableScrollPane);
        panel.add(returnButton);
        // add panel to window
        vgWindow.add(panel);
        vgWindow.setSize(600, 400);
        vgWindow.setLocationRelativeTo(null);
        vgWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vgWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            // handle button clicks
            if (event.getSource() == studentComboBox) {
                String selectedStudent = (String) studentComboBox.getSelectedItem();
                if (selectedStudent != null && !selectedStudent.equals("Select student...")) {
                    ArrayList<String[]> filteredData = new ArrayList<>();
                    for (String[] enrollment : CourseManagement.enrollments) {
                        if (enrollment[0].equals(selectedStudent)) {
                            String grade = "";
                            for (HashMap<String, String> gradeEntry : AddGrade.enrollmentGrades) {
                                if (gradeEntry.get("student").equals(selectedStudent) &&
                                gradeEntry.get("course").equals(enrollment[1])) {
                                    grade = gradeEntry.get("grade");
                                    break;
                                }
                            }
                            filteredData.add(new String[]{enrollment[1], grade});
                        }
                    }
                    tableData = filteredData.toArray(new String[0][0]);
                    gradeTable.setModel(new JTable(tableData, columnNames).getModel());
                } else {
                    tableData = new String[0][2];
                    gradeTable.setModel(new JTable(tableData, columnNames).getModel());
                }
            } else if (event.getSource() == returnButton) {
                vgWindow.dispose();
                new GradeManagement();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vgWindow, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}