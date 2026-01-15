package In_Out;

public class Out {
    public static void main(String[] args){
        // use "println" for print to screen and wrap the line
        System.out.println("Hello World !!!"); 
        
        // use "print" for print to screen but dose not wrap the line
        System.out.print("Hello ");
        System.out.print("World !!!");
        
        System.out.println();
        
        // use "printf" for print to screen with format
        System.out.printf("Hello World !!!\n");
        // we also add variables to this command :
        String str1="Hello ", str2="World !!!";
        System.out.printf("%s%s\n", str1, str2);
        
        // use "System.err" for print error line with red color
        System.err.println(str1+str2);
    }
}
