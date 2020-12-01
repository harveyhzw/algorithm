package Offer2;

import java.util.Arrays;

public class OfferAlgs {
    public static void main(String[] args) {
        int[] arr = new int[]{3,0,1,2,4,4,3,6,5,2,4,9};

    }

    /**
     * Offer 03
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
     * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     */
    public int findRepeatNumber(int[] nums) {

       /*Map<Integer, Integer> count = new HashMap<>();
       int length = nums.length;
       for (int i=0; i<length; i++ ) {
           if(count.containsKey(nums[i])) {
               return nums[i];
           } else {
               count.put(nums[i], 0);
           }
       }
       return -1;*/

        int length = nums.length;
        //int value = nums[0];
        int nextIndex = 0;
        while(true) {
            int value = nums[nextIndex];
            if(value != nextIndex) {
                int replace = nums[value];
                if (replace != value) {
                    nextIndex = replace;
                    nums[value] = value;
                } else {
                    return value;
                }
            } else {
                nextIndex++;
            }
        }
    }

    /**
     *  Offer 04
     *  在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     *  请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if(matrix == null || matrix.length==0 || matrix[0].length==0) {
            return false;
        }

        /*int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (matrix[i][j] == target)
                    return true;
            }
        }*/

        int rows = matrix.length;
        int columns = matrix[0].length;
        int r = 0;
        int c = columns-1;
        while(r<=rows-1&c>=0) {
            if (matrix[r][c] == target) {
                return true;
            } else if(matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }

    /**
     * Offer 29
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     */
    public int[] spiralOrder(int[][] matrix) {
        if(matrix== null || matrix.length==0 || matrix[0].length==0) {
            return new int[0];
        }

        int rows = matrix.length;
        int colums = matrix[0].length;
        int[] result = new int[rows*colums];

        int r1 = 0;
        int r2= matrix.length-1;
        int c1 = 0;
        int c2 = matrix[0].length-1;
        int index = 0;
        while(r1<=r2 && c1<=c2) {
            //上
            for(int i=c1; i<=c2; i++) {
                result[index] = matrix[r1][i];
                index++;
            }

            //右
            for(int i=r1+1;i<=r2; i++) {
                result[index] = matrix[i][c2];
                index++;

            }

            //下
            if(r1!=r2) {
                for(int i= c2-1; i>=c1; i--){
                    result[index] = matrix[r2][i];
                    index++;
                }
            }

            //左
            if(c1!=c2) {
                for(int i=r2-1; i>r1; i--){
                    result[index] = matrix[i][c1];
                    index++;
                }
            }

            r1++;r2--; c1++; c2--;
        }

        return result;
    }
}
