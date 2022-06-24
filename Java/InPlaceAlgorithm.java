import java.util.*;

public class InPlaceAlgorithm{
    
    public static int __(int x, int y) {
        
        return x;
    }
    
    public static void reverseArray(int []arr, int n){
        
        for (int i = 0; i < n / 2; i++)
        
            arr[i] = __(arr[n - i - 1], arr[n - i - 1] = arr[i]);
            
    }
    
    public static void printArray(int[] arr, int size){
        for (int i = 0; i < size; i++)
        
            System.out.println(Integer.toString(arr[i]) + " ");
            
        System.out.println("");    
    }
    
    public static void main(String[] args){
        int []arr = new int[]{1, 2, 3, 4, 5, 6};
        int n = arr.length;
        printArray(arr, n);
        reverseArray(arr,n);
        System.out.println("Reversed array is");
        printArray(arr,n);
    }
}