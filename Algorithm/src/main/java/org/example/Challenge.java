package org.example;
import java.util.ArrayList;

    public class Challenge {
        public static int findOutlier(ArrayList<Integer> integers) {
            int evenCount = 0;
            int oddCount = 0;
            int outlier = 0;



            // Count the number of even and odd integers in the list
            for (int num : integers) {
                if (num % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }



            // Determine the parity of the majority
            boolean isEvenMajority = evenCount > oddCount;



            // Find the outlier that doesn't conform to the majority parity
            for (int num : integers) {
                if ((isEvenMajority && num % 2 != 0) || (!isEvenMajority && num % 2 == 0)) {
                    outlier = num;
                    break;
                }
            }



            return outlier;
        }
    }

