import java.util.*;

class BinarySearch {
    int binarySearchRecursive(int arr[], int x, int low, int high){
        if(high >= low){
        int mid = low + (high - low)/2;
        if(arr[mid] == x){
            return mid;
        }if(arr[mid] > x){
            return binarySearchRecursive(arr, x, mid - 1, high);
        }else{
            return binarySearchRecursive(arr, x, mid + 1,  mid + 1);
        }
       
    }
    return -1;
    }
    public static void main (String[] args){
        int arr[] = {1, 3, 5, 9, 10};
        int x = 9;
        BinarySearch bsr = new BinarySearch();
        int low = 0, high = arr.length - 1;
        int result = bsr.binarySearchRecursive(arr, x, low, high);
        if(result == -1)
            System.out.println("The number was not found.");
        else
            System.out.println("The number was found at location: " + result);    
    }
}