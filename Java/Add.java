import java.util.*;

public class Add{
    public static void main (String[] args){

        int num1, num2, num3;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        
        num1 = sc.nextInt();
    
        System.out.println("Enter the second number: ");
        num2 = sc.nextInt();

        sc.close();
    
        num3 = num1 + num2;
    
        System.out.println("Final answer is: " + num3);   
    }

}