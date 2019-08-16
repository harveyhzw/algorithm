import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3,0,1,2,4,4,3,6,5,2,4,9};
        HeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void HeapSort(int [] array) {
        int length = array.length;
        for (int i = length/2 - 1; i>=0; i--) {
            adjustBigHeap(array, i, length);
        }

        for (int j= length-1; j > 0; j--) {
            swap(array, 0, j);
            adjustBigHeap(array, 0, j);
        }
    }

    public static void adjustBigHeap(int[] array, int i, int length) {

        int temp = array[i];

        for (int k=2*i + 1; k<length; k=2*k+1) {
            if(k+1 < length && array[k] < array[k+1]) {
                k = k+1;
            }

            if(temp < array[k]) {
                swap(array, i, k);
                i = k;
            } else {
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
