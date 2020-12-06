package Offer2;

import java.util.*;

public class OfferAlgs {
    public static void main(String[] args) {
        int[] arr = new int[]{3,0,1,2,4,4,3,6,5,2,4,9};

        System.out.println(firstUniqChar("loveleetcode"));

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

    /**
     * Offer 50
     * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。字符串只包含 ASCII 码字符。
     */
    public static  char firstUniqChar(String s) {
        if(s==null) return ' ';

        /*int length = s.length();
        Map<Character, Integer> count = new LinkedHashMap<>();
        for(int i=0;i<length; i++) {
            Character c = s.charAt(i);
            if(count.containsKey(c)){
                int value = count.get(c);
                count.put(c, ++value);
            } else{
                count.put(c, 1);
            }
        }

        Iterator iter = count.entrySet().iterator();

        while(iter.hasNext()) {
            Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>)iter.next();
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }*/

        int length = s.length();
        BitSet bs1 = new BitSet(128);
        BitSet bs2 = new BitSet(128);

        for(char c : s.toCharArray()) {
            if(!bs1.get(c)&&!bs2.get(c)){
                bs1.set(c);
            } else if(bs1.get(c)&&!bs2.get(c)) {
                bs2.set(c);
            }
        }

        for(int i=0; i<length; i++) {
            char c = s.charAt(i);
            if(bs1.get(c)&&!bs2.get(c)){
                return c;
            }
        }

        return ' ';
    }

    /**
     * Offer 9
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     */
    class CQueue {

        Stack<Integer> in = new Stack<Integer>();
        Stack<Integer> out = new Stack<Integer>();
        public CQueue() {

        }

        public void appendTail(int value) {
            in.push(value);
        }

        public int deleteHead() {
            if(out.isEmpty()){
                while(!in.isEmpty()) {
                    out.push(in.pop());
                }
            }

            if(!out.isEmpty()){
                return out.pop();
            }

            return -1;
        }


    }

    /**
     * Offer 40
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     */
    public int[]  topKLeastNumber(int[] arr, int k) {

        if(arr == null || arr.length<=k) {
            return arr;
        }

        int[] ret = new int[k];
        /*int length = arr.length;



        for(int i=length/2-1; i>=0; i--){
            addJustLittleHeap(arr, i, length);
        }

        int r=0;

        for(int j=length-1; j>0;j--) {

            if(r<k) {
                ret[r] = arr[0];
                r++;
            }
            else {
                break;
            }

            swap(arr, 0, j);
            addJustLittleHeap(arr, 0, j);
        }*/

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(Integer v : arr) {
            heap.add(v);
        }

        for(int i=0; i<k; i++) {
            ret[i] = heap.poll();
        }

        return ret;

    }

    private void addJustLittleHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for(int k=2*i+1; k<length;k=2*k+1) {
            if(k+1<length&&arr[k]>arr[k+1]) {
                k=k+1;
            }

            if(temp>arr[k]){
                swap(arr, i, k);
                i=k;
            } else{
                break;
            }
        }
    }

    static void swap(int array[], int indexA, int indexB){
        int a = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = a;
    }

}
