import java.util.*;

public class RecursiveJavaFactorialProgram {

    public static void main(String args[]) {

        long nFactorial = factorialProgram(9);

        System.out.println(nFactorial);

    }

    public static long factorialProgram(long n) {

        if(n <= 1){

            return 1;

        } else {

            return n * factorialProgram(n-1);

        }

    }
    
}