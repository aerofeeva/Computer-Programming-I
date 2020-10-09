// Program to test solutions to problem #8 on the cse142 midterm, winter 2016.
// Fill in your solution to isConsecutive, then compile and run the program.

import java.util.*;

public class Test8 {
    public static boolean isConsecutive(int n) {
        if (n < 10) {
           return true;
        }
        int digit = n % 10;
        n = n / 10;
        boolean flag = false;
        while (n != 0) {
            int nextDigit = n % 10;
            n = n / 10;
            if (nextDigit == (digit - 1)) {
               digit = nextDigit;
               flag = true;
            } else {
               flag = false;
            }
        }
        return flag;
    }

    // this is the sample solution
    public static boolean isConsecutive2(int n) {
        if (n < 10) {
            return true;
        } else {
            int lastDigit = n % 10;
            n = n / 10;
            while (n != 0) {
                int nextDigit = n % 10;
                n = n / 10;
                if (nextDigit != lastDigit - 1) {
                    return false;
                }
                lastDigit = nextDigit;
            }
            return true;
        }
    }

    private static int DISPLAY = 25;  // how many failed cases to display

    public static void main(String[] args) {
        // test 0 through 999,999, reporting up to DISPLAY errors
        int count = 0;
        int n = 0;
        int max = 999999;
        while (n <= max && count < DISPLAY) {
            if (!test(n)) {
                count++;
            }
            n++;
        }

        if (count == 0) {
            System.out.println("passed all " + n + " tests");
        } else {
            if (count > DISPLAY) {
                System.out.println("failed cases exeeds display max of " +
                                   DISPLAY);
                System.out.println();
            }
            System.out.println("failed " + count + " of " + n + " tests");
        }
    }

    public static boolean test(int n) {
        boolean ok = test2(n);
        if (!ok) {
            System.out.println("FAILS for n = " + n + " (should be " +
                               isConsecutive2(n) + ")");
        }
        return ok;
    }

    public static boolean test2(int n) {
        boolean test1;
        try {
            test1 = isConsecutive(n);
        } catch (RuntimeException e) {
            return false;
        }
        boolean test2 = isConsecutive2(n);
        return (test1 == test2);
    }
}