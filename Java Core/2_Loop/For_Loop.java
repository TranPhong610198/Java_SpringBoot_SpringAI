import java.util.*;
public class For_Loop {
    public static void main(String[] args){
        int sum =0; 
        Scanner scan = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = scan.nextInt();
        for (int i=1; i<=n; i++){
            sum+=i;
        }
        System.out.println("Sum from 1 to "+n+" equal: "+ sum);
    }
}
