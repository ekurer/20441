/**
 * Task 11 - part 1
 *
 * Ephraim Kurer
 * 312265549
 */
import java.util.Scanner;
public class Triangle
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);
        System.out.println ("This program calculates the area "
            + "and the perimeter of a given triangle. ");
        System.out.println ("Please enter the three lengths"
            + " of the triangle's sides");
        //user will insert triangle dimensions
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        double perimeter = a+b+c;
        double s = (perimeter)/2;
        //calculating Heron's formula
        double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        //excluding negative numbers and a degenerate triangle
        if (a<=0 || b<=0 || c<=0){
            System.out.println("One of your numbers " + a + "," + b + "," + c + " is not a natural number");
        } else if ((a+b<=c)||(a+c<=b)||(b+c<=a)){
            System.out.println("Your triangle is degenerate triangle");
        } else 
            System.out.println("The triangle perimeter is " + perimeter + " and the area is " + area);
    }   
}
// end of method main
//end of class Triangle

