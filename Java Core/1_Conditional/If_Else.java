import java.util.*;
public class If_Else {

    // a function for easy to input
    public static String input(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }

    // a function use normal conditional operator
    public static int fMin(int num1, int num2){
        if (num1>num2) return num2;
        return num1;
    }
    
    // a function use ternary operator
    public static String typeNum(int num3){
        return ("num3("+num3+")" + ((num3 % 2 == 0)?" is even number":" is odd number"));
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(input("Enter number 1: "));
        int num2 = Integer.parseInt(input("Enter number 2: "));
        int num3 = Integer.parseInt(input("Enter number 3: "));
        System.out.println("Min of num1("+num1+") and num2("+num2+") is: "+ fMin(num1, num2));
        System.out.println(typeNum(num3));        
    }
}
