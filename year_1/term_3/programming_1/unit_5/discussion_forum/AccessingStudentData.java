// private class
class StudentEncapsulation {
    // private variables
    private String studentName = "Micheal Brandon";
    private int studentID = 2413;

    // getter for studentName
    public String getStudentName() {
        return studentName;
    }

    // setter for studentName
    public void setStudentName(String newStudentName) {
        studentName = newStudentName;
    }
    /*
     * Note that there are no getter and setters for studentID,
     * making it inaccessible
     */
}

// public class
public class AccessingStudentData {
    /*
     * using a getter for studentName, but there is no getter for studentID.
     * attempting to access studentID will result in a compilation error,
     * because it is private and has no getter
     */
    public static void main(String[] args) {
        // creating object 
        StudentEncapsulation student = new StudentEncapsulation();
        // using getter to display studentName
        System.out.println("The name of the student is: " + student.getStudentName());
        // will cause an error during compilation because studentID is private and there is no getter
        System.out.println("The ID of the student is: " + student.studentID); 
    }
}
