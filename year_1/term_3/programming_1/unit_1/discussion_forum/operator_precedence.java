public class operator_precedence {
    public static void main(String[] args) {
        double tax = 0.13;
        int sal = 53546;
        /* Below we use parentheses to calculate the post-tax remaining percentage,
         * which is then multiplied by the sal amount. Without the parentheses,
         * the order of operations would be sal multiplied by 1, then tax is subtracted from it.
         * This results in a semantic error.
         */
        double sal_after_tax = sal * (1 - tax);
        System.out.println(sal_after_tax);
    }
}