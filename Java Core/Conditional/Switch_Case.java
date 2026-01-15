import java.util.*;
public class Switch_Case {
    public static int addNumber(int num1, int num2){
        return num2 + num1;
    }
    
    public static String typeNum(int num3){
        return ((num3 % 2 == 0) ? num3+" is even number" : num3+" is odd number");
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("1. Hello World");
        System.out.println("2. Even or Odd");
        System.out.println("3. Add Two Number");

        System.out.print("Input Your Choice: ");
        int choice = scan.nextInt();
        
        switch (choice){
            case 1:
                System.out.println("HelloWorld!!!");
                break;
            case 2:
                System.out.print("Input number: ");
                int num = scan.nextInt();
                System.out.println(typeNum(num));
                break;
            case 3:
                System.out.print("Number 1: ");
                int num1 = scan.nextInt();
                System.out.print("Number 2: ");
                int num2 = scan.nextInt();
                System.out.println("Result: " + addNumber(num1, num2));
                break;
            default:
                System.err.println("Error Chosen !!!");
                break;
        }
    }
}
