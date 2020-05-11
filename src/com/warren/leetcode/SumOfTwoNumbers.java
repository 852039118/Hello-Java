package com.warren.leetcode;

public class SumOfTwoNumbers {
    private static int i = 0;
    private static int j = 0;

    public SumOfTwoNumbers() {
    }

    public static void main(String[] args) {
        System.out.printf(twoSum(new int[]{2, 7, 11, 15}, 9).toString());
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] returnNum = new int[2];

        for(i = 0; i <= nums.length - 1; ++i) {
            for(j = 1; j <= nums.length - 1; ++j) {
                if (nums[i] + nums[j] == target) {
                    returnNum = new int[]{i, j};
                    return returnNum;
                }
            }
        }

        return null;
    }

    public String toString() {
        String var10000 = String.valueOf(i);
        return var10000 + String.valueOf(j);
    }
}