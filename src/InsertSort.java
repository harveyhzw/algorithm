import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {

        int[] arr = new int[]{3,0,1,2,4,4,3,6,5,2,4,9};
        SimpleInsertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void SimpleInsertSort(int array[]) {
        if (array.length <=1 ) return;
        for (int i=1; i< array.length; i++) {
            int p = array[i];
            int j = i -1;
            while(j>=0 && array[j]>p) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = p;
        }
    }
}
