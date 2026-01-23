import java.util.*;
public class learnArray {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] arr1 = new int[5];
        for (int i=0; i<5; i++){
            arr1[i] = scan.nextInt();
        }
        
        for ( int i=0; i<arr1.length; i++){
            System.out.print(arr1[i] + " ");
        }
    }
}
