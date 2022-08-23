/**
 * Class that determines whether or not a year is a leap year.
 * @author YOUR NAME HERE
 */
public class LeapYear {

    /**
     * Update this comment to describe what this method does.
     */
    public static boolean isLeapYear(int year) {
        // Optional TODO: Fill in this method.
    }

    /** Calls isLeapYear to print correct statement. */
    private static void checkLeapYear(int year) {
        if (isLeapYear(year)) {
            System.out.printf("%d is a leap year.\n", year);
        } else {
            System.out.printf("%d is not a leap year.\n", year);
        }
    }

    /** Basic (Optional) Sanity Tests */
    public static void main(String[] args) {
        System.out.println("Checking the year 2000, which should be a leap year:");
        checkLeapYear(2000);
        System.out.println("Checking the year 1700, which should be not a leap year:");
        checkLeapYear(1700);
    }
}
