package org.example;
import java.util.HashMap;


public class OutlierFinder {
    /*You are given an array (which will have a length of at least 3, but could be very large)
        containing integers. The array is either entirely comprised of odd integers or
        entirely comprised of even integers except for a single integer N. Write a method
        that takes the array as an argument and returns this "outlier" N.*/


        public static int findOutlier(int[] nums) {

            HashMap<Integer, Integer> oddMap = new HashMap<>();
            HashMap<Integer, Integer> evenMap = new HashMap<>();
            for (int num : nums) {
                if (num % 2 == 0) {
                    evenMap.put(num, evenMap.getOrDefault(num, 0) + 1);
                } else {
                    oddMap.put(num, oddMap.getOrDefault(num, 0) + 1);
                }
            }
            if (oddMap.size() == 1) {
                return oddMap.keySet().iterator().next();
            } else {
                return evenMap.keySet().iterator().next();
            }
        }
        public static void main(String[] args) {
            int[] arr = {2, 4, 6, 10, 3};
            int outlier = findOutlier(arr);
            System.out.println("Outlier: " + outlier);
        }
    }

