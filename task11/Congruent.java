/**
 * Task 11 - part 2
 *
 * Ephraim Kurer
 * 312265549
 */
import java.util.Scanner;

public class Congruent
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);
        System.out.println ("This program calculates if the triangles you inserted"
            + "are Congruent or not.");
        System.out.println ("Please enter the three certics"
            + " of triangle a (x+y,x+y,x+y)");
        double x11 = scan.nextDouble();
        double y11 = scan.nextDouble();
        double x12 = scan.nextDouble();
        double y12 = scan.nextDouble();
        double x13 = scan.nextDouble();
        double y13 = scan.nextDouble();
        System.out.println ("Please enter the three certics"
            + " of triangle b (x+y,x+y,x+y)");
        double x14 = scan.nextDouble();
        double y14 = scan.nextDouble();
        double x15 = scan.nextDouble();
        double y15 = scan.nextDouble();
        double x16 = scan.nextDouble();
        double y16 = scan.nextDouble();
        //the perimiter of the first triangle
        double a1 =Math.sqrt(Math.pow((x11-x12),2)+(Math.pow((y11-y12),2)));
        double b1 =Math.sqrt(Math.pow((x12-x13),2)+(Math.pow((y12-y13),2)));
        double c1 =Math.sqrt(Math.pow((x13-x11),2)+(Math.pow((y13-y11),2)));
        //the perimiter of the second triangle
        double a2 =Math.sqrt(Math.pow((x14-x15),2)+(Math.pow((y14-y15),2)));
        double b2 =Math.sqrt(Math.pow((x15-x16),2)+(Math.pow((y15-y16),2)));
        double c2 =Math.sqrt(Math.pow((x16-x14),2)+(Math.pow((y16-y14),2)));
        //announcing the triangles measurements
        System.out.println("The first triangle is (" + x11 + "," + y11 + "," + x12 + "," + y12 + "," + x13 + "," + y13 + ")");
        System.out.println("It's lengths are " + a1+ ", " + b1 + ", " + c1 + ".");
        System.out.println("The second triangle is (" + x14 + "," + y14 + "," + x15 + "," + y15 + "," + x16 + "," + y16 + ")"); 
        System.out.println("It's lengths are " + a2+ ", " + b2 + ", " + c2 + ".");
        //check if the triangles are congruent
        
        if (((a1==a2)||(a1==b2)||(a1==c2))&&((b1==a2)||(b1==b2)||(b1==c2))&&((c1==a2)||(c1==b2)||(c1==c2)))
        System.out.println("The triangles are congruent.");
        else
        System.out.println("The triangles are not congruent.");
    }
}
// end of method main
//end of class Congruent