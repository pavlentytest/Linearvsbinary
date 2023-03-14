import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        // Collections.sort();
        // Arrays.sort()

        int[] number = new int[1000000];
        for(int i=0; i<number.length; i++) {
            number[i] = i;
        }
        long start = System.nanoTime();
        System.out.println(linearSearch(900000,number));
        long end = System.nanoTime();
        System.out.println("linear = "+(end-start));

        start = System.nanoTime();
        binarySearch(900000,number);
        end = System.nanoTime();
        System.out.println("binary = "+(end-start));

        start = System.nanoTime();
        Arrays.binarySearch(number, 900000);
        end = System.nanoTime();
        System.out.println("Arrays binary = "+(end-start));


    }

    public static int linearSearch(int value, int[] array) {
        for(int i=0; i<array.length; i++) {
            if(array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int value, int[] array) {
        int left = 0;
        int right = array.length;
        while(left < right) {
            int middle = (left+right)/2;
            if(array[middle] == value) {
                return middle;
            }
            if(array[middle] > value) {
                right = middle;
            } else if(array[middle] < value) {
                left = middle+1;
            }
        }
        return -1;
    }
}