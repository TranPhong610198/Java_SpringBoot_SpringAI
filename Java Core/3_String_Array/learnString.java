public class learnString{
    public static void main(String[] args){
        // print a string
        String str1 = "Hello World !!!";
        String str2 = "hello world !!!";
        System.out.println(str1);
        
        // Show character at index in String
        System.out.println(str1.charAt(6));
        
        // Compare two String and compare ignore case
        int test1 = str1.compareTo(str2);
        int test2 = str1.compareToIgnoreCase(str2);
        System.out.println(test1); // not equals return negative it str1<str2 vice versa
        System.out.println(test2); // equals return 0
    
        // Check equalation between two string, and return boolean 
        boolean test3 = str1.equals(str2);
        boolean test4 = str1.equalsIgnoreCase(str2); 
        System.out.println(test3);
        System.out.println(test4);
        
        // See more method about String in here:  https://www.programiz.com/java-programming/string
    }
}