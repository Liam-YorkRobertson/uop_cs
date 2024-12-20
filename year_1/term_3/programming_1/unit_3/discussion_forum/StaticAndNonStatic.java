public class StaticAndNonStatic {
    // static variable
    static int staticValue = 5; 
    // non-static variable
    int nonStaticValue = 4;     

    public static void main(String[] args) {
        // accessing static method
        static_two_times(); 
        // creating object to access non-static method
        StaticAndNonStatic obj = new StaticAndNonStatic();
        // accessing non-static method
        obj.non_static_sum(); 
    }
    // static method accessing static variable
    static void static_two_times() {
        staticValue *= 2;
        System.out.println(staticValue);
    }
    // non-static method accessing both variables
    void non_static_sum() {
        nonStaticValue += staticValue;
        System.out.println(nonStaticValue);
    }
}