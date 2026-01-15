// Calculate Factorial of Number Using Recursion
import java.util.*;
public class Java_Recursion {
    public static int Factorial(int n){
        if (n != 0) return n*Factorial(n-1);
        return 1;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number: ");
        int num = sc.nextInt();
        System.out.println(num+"! = " + Factorial(num));
        
    }
}
