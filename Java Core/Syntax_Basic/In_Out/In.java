package In_Out;
import java.util.*;
public class In {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int age = sc.nextInt(); 
    sc.nextLine(); // to take the "enter" character
    String name1 = sc.nextLine(); // nextLine() for take full line
    String name2 = sc.next(); // next() to take String before first space
    
    System.out.println(age);
    System.out.println(name1);
    System.out.println(name2);
    }
}
