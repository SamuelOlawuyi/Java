package org.example;
public class Challenge {
    /*
Write a function that checks a string to see if it has the same amount of xs and os.
The case of the characters should be ignored, so x and X are equivalent, as are o and O.
 The method must return a boolean. The string can contains any other char, which will be ignored.
  Examples Input Output Comments "ooxx" true "xooxx" false "ooxXm" true Ignore case "zpzpzpp" true
  When there are no xs or os, return true "zzoo" false Documentation evenXAndO(str)
  Parameters: str: String A string of characters. Guaranteed Constraints:
  The input will never be null or undefined. The string may be empty.
  Returns: boolean Return true if the total number of xs and Xs is the same as the total number of os and Os (including zero).
   Otherwise, return false. public class Challenge { public static boolean evenXAndO(String str) { return true; } }.*/

            // This is just the logic
    public static long findNextSquare(long num) {
        long sqrt = (long) Math.sqrt(num);
        if (sqrt * sqrt == num) {
            long nextSqrt = sqrt + 1;
            return nextSqrt * nextSqrt;
        } else {
            return -1;

        }
    }
}
