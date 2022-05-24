import java.util.*;
//given a list of numbers find the following number in the list
public class LinearSearch{

    public static void main (String[] args){
        int[] listOfNumbers = new int[]{1, 2, 3, 4, 5};
        int searchFor;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number that you want to search for: ");
        searchFor = sc.nextInt();
        if(search(searchFor, listOfNumbers)){
            System.out.println("Number found!");
        }
        else{
            System.out.println("Number not found :( ");
        }

        sc.close();
    }

    public static boolean search(int number, int listOfNumbers[]){
        for(int i = 0; i < listOfNumbers.length; i++){
            if(listOfNumbers[i] == number)
            return true;
        }
        return false;
    }
}