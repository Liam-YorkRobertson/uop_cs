import java.util.ArrayList;

public class ArrayVsArrayList {
    public static void main(String[] args) {
        // calculates execution time of array manipulation
        long timeStartA = System.nanoTime();
        time_array();
        long timeEndA = System.nanoTime();
        long executionTimeA = timeEndA - timeStartA;
        System.out.println("execution time of array manipulation: " + executionTimeA + "ns");
        // calculates execution time of arrayList manipulation
        long timeStartAL = System.nanoTime();
        time_array_list();
        long timeEndAL = System.nanoTime();
        long executionTimeAL = timeEndAL - timeStartAL;
        System.out.println("execution time of ArrayList manipulation: " + executionTimeAL + "ns");
    }

    private static void time_array() {
        // create empty array that can hold 5 elements, then filled it
        String[] bandMembers = new String[5];
        bandMembers[0] = "Corey Taylor";
        bandMembers[1] = "James Root";
        bandMembers[2] = "Mick Thompson";
        bandMembers[3] = "Sid Wilson";
        bandMembers[4] = "Shawn Crahan";
    }

    private static void time_array_list() {
        // create empty ArrayList, then add 5 elements to it
        ArrayList<String> bandMembers = new ArrayList<String>();
        bandMembers.add("Corey Taylor");
        bandMembers.add("James Root");
        bandMembers.add("Mick Thompson");
        bandMembers.add("Sid Wilson");
        bandMembers.add("Shawn Crahan");
    }
}