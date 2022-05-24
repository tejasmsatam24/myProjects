import java.util.*;

import javax.print.attribute.standard.Media;

public class BinarySearchIterative{
    int binarySearchIterative(int arr[], int x){
        int low = 0, high = arr.length - 1;
        while(low <= high){
            int m = (low + high)/2;
            if(arr[m] == x){
                return m;
            }if(arr[m] > x){
                high = m-1;
            }else {
                low = m + 1;
            }
        }
        return -1;
    }
    public static void main (String[] args){
        int arr[] = {2, 3, 5, 10};
        int x = 10;
        BinarySearchIterative bsi = new BinarySearchIterative();
        int result = bsi.binarySearchIterative(arr, x);
        if(result == -1){
            System.out.println("Element found");
        }else{
            System.out.println("The elament found at index: " + result);
        }
    }
}