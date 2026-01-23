import java.util.*;
public class For_Each_Loop {
    public static void main(String[] args){
        int [] arr1 = {1, 2, 3, 6, 9, 19};
        int sum =0;
        for (int x : arr1){
            if (x%2 != 2) sum+=x;
        }
        System.out.print ("Array: ");
        for (int x:arr1) {
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("Sum of odd numbers in arr1 is: "+sum);
    }
}
