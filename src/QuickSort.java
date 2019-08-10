import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        Integer age = 4;

        System.out.println("test");

        //String str = new String.format("test%d", 3);
        //str  = String.format("test%d", 3);
        //Inner

        int[] arr = new int[]{3,0,1,2,4,4,3,6,5,2,4,9};
        quickSort2(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static  void quickSort(int[] array, int left, int right){

        if (left>right) return;

        int p = array[right];
        int l = left;
        int r = right;

        while (l!=r) {
            while(array[l] <= p && l<r) {
                l++;
            }
            while(array[r] >= p && l<r) {
                r--;
            }
            if(l<r) {
                swap(array, l, r);
            }
        }

        array[right] = array[r];
        array[r] = p;

        quickSort(array, 0, l-1);
        quickSort(array, l+1, right);
    }

    public static void quickSort2(int[] array, int left, int right){
        int start = left;
        int end = right;
        if(start>end) return;
        int temp = array[right];
        while(left<right){
            while (left<right && array[left]<=temp){
                left++;
            }
            array[right] = array[left];
            while (left<right && array[right]>=temp){
                right--;
            }
            array[left] = array[right];
        }
        array[right] = temp;

        quickSort2(array, start, right-1);
        quickSort2(array, right+1, end);
    }

    static void swap(int array[], int indexA, int indexB){
        int a = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = a;
    }


}
