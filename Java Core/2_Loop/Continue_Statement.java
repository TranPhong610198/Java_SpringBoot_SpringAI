import java.util.Scanner;
public class Continue_Statement {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] arr = {1, 3, 4, 6, 9, 10, 14, 12, 13, 11, 15};
        boolean test=false;
        
        System.out.print("Array: ");
        for (int x:arr) System.out.print(x+" ");
        System.out.println();
        
        System.out.print("Input number: ");
        int find = scan.nextInt();
        for (int x:arr){
            if (x != find) continue;
            else{ 
                test = true;
                break;
            }
        }        
        if(test == true) System.out.println(find +" was found in array");
        else System.out.println(find +" was not found in array");
    }
}
