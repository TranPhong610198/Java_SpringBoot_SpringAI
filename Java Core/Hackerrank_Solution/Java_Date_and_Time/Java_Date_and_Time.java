// Print Day with Date given before
// 1st January 1000 is WEDNESDAY
package java_date_and_time;

import java.util.*;

public class Java_Date_and_Time {
    
    // check Validate
    public static boolean validDate(int day, int month, int year){
        if (day<0 || month<0 || month>12 || year < 0) return false;
        return true;
    }

    // check LeapYear
    public static boolean checkLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0);
    }

    // calculate Day of Month
    public static int dayOfMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (checkLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
        }
        return 0;
    }

    // count LeapYear
    public static int countLeapYear(int startY, int endY) {
        int count = 0;
        for (int i = startY; i < endY; i++) {
            if (checkLeapYear(i)) {
                count++;
            }
        }
        return count;
    }

    // oder of date in year
    public static int oderOfDate(int day, int month, int year) {
        int result = day;
        for (int i = 1; i < month; i++) {
            result += dayOfMonth(i, year);
        }
        return result;
    }

    // calculate numbers of day from rootDay to inputDay
    public static int calDays(int day, int month, int year) {
        int result = (year - 1000 - countLeapYear(1000, year)) * 365 + countLeapYear(1000, year) * 366 + oderOfDate(day, month, year)-1;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Date Folow Type DD MM YY (Year need greatter than 1000): ");
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();
        
        while (!validDate(day, month, year)){
            System.err.print("Invalid Date, Input Again: ");
            System.out.print("Input Date Folow Type DD MM YY (Year need greatter than 1000): ");
            day = sc.nextInt();
            month = sc.nextInt();
            year = sc.nextInt();            
        }
        
        

        int temp = calDays(day, month, year)%7;
        int DayCode = (2 + temp) % 7;
        switch (DayCode){
            case 0:
                System.out.println("MONDAY");
                break;
            case 1:
                System.out.println("TUESDAY");
                break;                
            case 2:
                System.out.println("WEDNESDAY");
                break;                
            case 3:
                System.out.println("THIRDAY");
                break;                
            case 4:
                System.out.println("FRIDAY");
                break;                
            case 5:
                System.out.println("SATURDAY");
                break;                
            case 6:
                System.out.println("SUNDAY");
                break;                
        }
        }
    }