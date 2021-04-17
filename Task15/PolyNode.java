/** 
 * a class that contains a node with a polynom
 */

public class PolyNode
{
    private int _power ;
    private double _coefficient;
    private PolyNode _next;
    /** consructor that takes two paramters and creates a new polynode object
     * and sets the next to be null
     * @param int power
     * @param double coefficient
     */
    public PolyNode(int power, double coefficient){
        if(power >= 0){
            _power = power;
            _coefficient = coefficient;
        }
        else {
            _power = 0;
            _coefficient = 0;
        }
        _next = null;
    }

    /** consructor that takes three paramters and creates a polynode object
     * @param int power
     * @param double coefficient
     * @param PolyNode next
     */
    public PolyNode(int power, double coefficient, PolyNode next){
        if(power >= 0){
            _power = power;
            _coefficient = coefficient;
        }
        else {
            _power = 0;
            _coefficient = 0;
        }
        _next = next;
    }

    /** a copy constructor
     * @param PolyNode p - the PolyNode to copy
     */
    public PolyNode (PolyNode p){
        _power = p._power;
        _coefficient = p._coefficient;
        _next = p._next;
    }

    public int getPower(){
        return (_power);
    }

    public double getCoefficient(){
        return (_coefficient);
    }

    public PolyNode getNext(){
        return (_next);
    }

    public void setPower (int power){
        if(power >= 0)
            _power=power;    
    }

    public void setCoefficient (double coefficient){
        _coefficient=coefficient;
    }

    public void setNext (PolyNode next){
        _next=next;
    }

    /** a toString mothed that return a string with the power and coefficient 
     * and takes into consideration different cases
     */
    public String toString(){
        String res = "";
        if (_coefficient==0)
            return "";
        if (_power ==0)
            return Double.toString(_coefficient);

        if (_coefficient==-1)
            res+="-";
        else if (_coefficient!=1)
            res+=Double.toString(_coefficient);
        res+="x";
        if (_power!=1)
            res+="^"+_power;
        return res;
    }
}
