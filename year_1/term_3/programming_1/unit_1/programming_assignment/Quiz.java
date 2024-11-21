import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        double count = 0; // keeps track of number of correct answers
        char answer1 = ' ', answer2 = ' ', answer3 = ' ', answer4 = ' ', answer5 = ' '; // stores each answer
        double totalPercentage; // initialising percentage score on quiz

        System.out.println("""
                Welcome to the NBA quiz! \n
                Get ready to answer 5 simple questions about the NBA!
                """);
        
        // first question
        System.out.println("""
                Question 1: \n
                What does the abbreviation NBA stand for:

                    A. Northern Baseball Association 
                    B. National Basketball Association
                    C. National Bureau of America 
                    D. Norwegian Badminton Arena
                """);
        // creates Scanner container to read user inputs
        Scanner myObj = new Scanner(System.in);
        // asks user to input an answer for the first question
        System.out.println("Enter your Answer (A, B, C or D):");
        // temporarily stores user input as a string 
        String tempAnswer1 = myObj.nextLine();
        
        // if statement to ensure the string only contains one character
        if (tempAnswer1.length() == 1) {
            // converts string type to char type 
            answer1 = tempAnswer1.charAt(0);
        } else {
            //error if the user inputs more than one character in their string
            System.out.println("Error! You chose an invalid option! Please select A, B, C or D");
            System.exit(1);
        }

        // switch case to determine what to do with user input for first question
        switch (answer1) {
            // if the user's answer is correct then count is incremented
            case 'B', 'b' -> {
                count++;
            }
            //if the user's answer is incorrect then it does nothing
            case 'A', 'C', 'D', 'a', 'c', 'd' -> {
                ;
            }
            //if the user inserts an invalid data type or option then an error is displayed
            default -> {
                System.out.println("Error! You chose an invalid option! Please select A, B, C or D");
                System.exit(1);
            }
        }
        
        // second question
        System.out.println("""
                \nQuestion 2: \n
                Which team won the 2024 NBA Championship:

                    A. Denver Nuggets 
                    B. San Fransisco Warriors
                    C. Boston Celtics 
                    D. Cleveland Cavaliers
                """);
        // asks user to input an answer for the second question
        System.out.println("Enter your Answer (A, B, C or D):"); 
        // temporarily stores user input as a string 
        String tempAnswer2 = myObj.nextLine();

        // if statement to ensure the string only contains one character
        if (tempAnswer2.length() == 1) {
            // converts string type to char type 
            answer2 = tempAnswer2.charAt(0);
        } else {
            // error if the user inputs more than one character in their string
            System.out.println("Error! You chose an invalid option! Please select A, B, C or D");
            System.exit(1);
        }

        // switch case to determine what to do with user input for second question
        switch (answer2) {
            // if the user's answer is correct then count is incremented
            case 'C', 'c' -> {
                count++;
            } 
            // if the user's answer is incorrect then it does nothing
            case 'A', 'B', 'D', 'a', 'b', 'd' -> {
                ;
            }
            // if the user inserts an invalid data type or option then an error is displayed
            default -> {
                System.out.println("Error! You chose an invalid option! Please select A, B, C or D");
                System.exit(1);
            }
        }

        // third question
        System.out.println("""
                \nQuestion 3: \n
                Which team has the most NBA Championships of 18:

                    A. Los Angeles Lakers 
                    B. San Fransisco Warriors
                    C. Miami Heat 
                    D. Boston Celtics
                """);
        // asks user to input an answer for the third question
        System.out.println("Enter your Answer (A, B, C or D):"); 
        // temporarily stores user input as a string 
        String tempAnswer3 = myObj.nextLine();
        
        // if statement to ensure the string only contains one character
        if (tempAnswer3.length() == 1) {
            // converts string type to char type 
            answer3 = tempAnswer3.charAt(0);
        } else {
            // error if the user inputs more than one character in their string
            System.out.println("Error! You chose an invalid option! Please select A, B, C or D");
            System.exit(1);
        }

        // switch case to determine what to do with user input for third question
        switch (answer3) {
            // if the user's answer is correct then count is incremented
            case 'D', 'd' -> {
                count++;
            } 
            // if the user's answer is incorrect then it does nothing
            case 'A', 'B', 'C', 'a', 'b', 'c' -> {
                ;
            }
            // if the user inserts an invalid data type or option then an error is displayed
            default -> {
                System.out.println("Error! You chose an invalid option! Please select A, B, C or D");
                System.exit(1);
            }
        }

        // fourth question
        System.out.println("""
                \nQuestion 4: \n
                Who is the leading all-time scorer of the NBA:

                    A. Lebron James
                    B. Micheal Jordan
                    C. Kobe Bryant
                    D. Dirk Nowitzki
                """);
        // asks user to input an answer for the fourth question
        System.out.println("Enter your Answer (A, B, C or D):"); 
        // temporarily stores user input as a string 
        String tempAnswer4 = myObj.nextLine();

        // if statement to ensure the string only contains one character
        if (tempAnswer4.length() == 1) {
            // converts string type to char type 
            answer4 = tempAnswer4.charAt(0);
        } else {
            // error if the user inputs more than one character in their string
            System.out.println("Error! You chose an invalid option! Please select A, B, C or D");
            System.exit(1);
        }

        // switch case to determine what to do with user input for fourth question
        switch (answer4) {
            // if the user's answer is correct then count is incremented
            case 'A', 'a' -> {
                count++;
            } 
            // if the user's answer is incorrect then it does nothing
            case 'B', 'C', 'D', 'b', 'c', 'd' -> {
                ;
            }
            // if the user inserts an invalid data type or option then an error is displayed
            default -> {
                System.out.println("Error! You chose an invalid option! Please select A, B, C or D");
                System.exit(1);
            }
        }

        // fifth question
        System.out.println("""
                \nQuestion 5: \n
                Who is the leading all-time 3-point scorer of the NBA:

                    A. Stephen Curry
                    B. Klay Thompson
                    C. Damian Lillard
                    D. James Harden
                """);
        // asks user to input an answer for the fifth question
        System.out.println("Enter your Answer (A, B, C or D):"); 
        // temporarily stores user input as a string 
        String tempAnswer5 = myObj.nextLine();

        // if statement to ensure the string only contains one character
        if (tempAnswer5.length() == 1) {
            // converts string type to char type 
            answer5 = tempAnswer5.charAt(0);
        } else {
            // error if the user inputs more than one character in their string
            System.out.println("Error! You chose an invalid option! Please select A, B, C or D");
            System.exit(1);
        }

        // switch case to determine what to do with user input for fifth question
        switch (answer5) {
            // if the user's answer is correct then count is incremented
            case 'A', 'a' -> {
                count++;
            } 
            // if the user's answer is incorrect then it does nothing
            case 'B', 'C', 'D', 'b', 'c', 'd' -> {
                ;
            }
            // if the user inserts an invalid data type or option then an error is displayed
            default -> {
                System.out.println("Error! You chose an invalid option! Please select A, B, C or D");
                System.exit(1);
            }
        }

        // after count has kept track of all correct answers, calculate the percentage teh user got correct
        totalPercentage = (count / 5) * 100;
        // converts double back to int to be visually appealing 
        int intPercentage = (int) totalPercentage;
        // displays user's percentage score on the quiz
        System.out.println("\nYou scored " + intPercentage + "% on the quiz!");
    }
}