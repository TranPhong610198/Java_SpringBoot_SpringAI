import java.util.*;
public class If_Else {
    
    // a function use normal conditional operator
    public static int fMin(int num1, int num2){
        if (num1>num2) return num2;
        return num1;
    }
    
    // a function use ternary operator
    public static String typeNum(int num3){
        return ((num3 % 2 == 0) ? num3+" is even number" : num3+" is odd number");
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();
        System.out.println("Min of "+num1+" and "+num2+" is: "+ fMin(num1, num2));
        System.out.println(typeNum(num3));        
    }
}
