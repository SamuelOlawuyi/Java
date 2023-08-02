package org.example;


public class Challenge {
    /*You might know some pretty large perfect squares.
    But what about the next one? Create a method that finds the next integral perfect square
     after the one passed as a parameter. Recall that an integral perfect square is an integer n
     such that sqrt(n) is also an integer. If the parameter is itself not a perfect square,
     than -1 should be returned. You may assume the parameter is positive.
      Examples Input Output Comments 121 144 625 676 114 -1 Since 114 is not a perfect square
       Documentation findNextSquare(num) Parameters: num: long or int An integer greater than 0.
       Guaranteed Constraints: The input will always be an integer, it will never be null or undefined.
       The input integer will always be greater than 0 (no negative inputs). Returns: long or int
       If the input is a perfect square, return the next perfect square. If it is not a perfect square,
        return -1. public class Challenge { public static long findNextSquare(long num) { return 0; } } N.*/


        public static boolean evenXAndO(String str) {
            int countX = 0;
            int countO = 0;



            for (char ch : str.toCharArray()) {
                if (ch == 'x' || ch == 'X') {
                    countX++;
                } else if (ch == 'o' || ch == 'O') {
                    countO++;
                }
            }



            return countX == countO;
        }



        public static void main(String[] args) {
            System.out.println(evenXAndO("ooxx"));    // Output: true
            System.out.println(evenXAndO("xooxx"));   // Output: false
            System.out.println(evenXAndO("ooxXm"));   // Output: true
            System.out.println(evenXAndO("zpzpzpp")); // Output: true
            System.out.println(evenXAndO("zzoo"));    // Output: false
        }
    }

