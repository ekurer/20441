/** 
 * a class the contains a polynom
 */

public class Polynom
{
    private PolyNode _head;

    /**
     * a constructor that sets head to be null
     * Time complexity O(1)
     * Space complexity O(1)
     */
    public Polynom(){
        _head = null;
    }

    /**
     * a constructor that sets head to be a parameter
     * @param PolyNode p
     * Time complexity O(1)
     * Space complexity O(1)
     */
    public Polynom (PolyNode p){
        _head = p;
    }

    /**
     * a method that returns the first polynode in the list
     * Time complexity O(1)
     * Space complexity O(1)
     */
    public PolyNode getHead(){
        return _head;
    }

    /**
     * a method that sets the first polynode in the list to be p
     * @param PolyNode p
     * Time complexity O(1)
     * Space complexity O(1)
     */
    public void setHead (PolyNode p){
        _head= p;
    }

    /**
     * a method that takes an object from the PolyNode class and places it
     * in the list by order
     * @param PolyNode p
     * Time complexity O(n)
     * Space complexity O(1)
     */
    public Polynom addNode (PolyNode p){
        PolyNode copy = new PolyNode(p);
        copy.setNext(null);
        PolyNode p1 = _head;
        if (_head==null){
            _head=copy;
        }
        else if(_head.getPower() < copy.getPower()){
            copy.setNext(_head);
            _head = copy;
        }

        else     
        { 
            boolean inserted = false;
            while(p1.getNext() != null){
                if (p1.getPower()==copy.getPower()){
                    p1.setCoefficient(p1.getCoefficient()+copy.getCoefficient());
                    inserted = true;
                    break;
                }

                if(p1.getNext().getPower() < copy.getPower()){
                    copy.setNext(p1.getNext());
                    p1.setNext(copy);
                    inserted = true;
                    break;
                }
                p1 = p1.getNext();

            }
            if (inserted == false) {         
                if (p1.getPower()==copy.getPower()){
                    p1.setCoefficient(p1.getCoefficient()+copy.getCoefficient());
                }
                else{
                    p1.setNext(copy);
                }

            }
        }
        return this;
    }

    /**
     * a method that takes an integer and returns the result of multiplying it
     * by the Polynom
     * @param int num
     * Time complexity O(n)
     * Space complexity O(1)

     */
    public Polynom multByScalar(int num){
        PolyNode p1 = _head;
        while (p1!=null){
            p1.setCoefficient(p1.getCoefficient()*num);
            p1 = p1.getNext();
        }
        return this;
    }

    /**
     * a method that takes an Polynom and returns the result of adding it
     * to the list (if powers are identical we add them together)
     * @param Polynom other
     * Time complexity O(n^2)
     * Space complexity O(1)
     */
    public Polynom addPol (Polynom other){
        if(other != null){
            PolyNode p1 = other._head;
            while (p1!=null){
                this.addNode(p1);
                p1 = p1.getNext();
            }
        }
        return this;
    }

    /**
     * a method that takes an Polynom and returns the result of multiplying it
     * by the list
     * @param Polynom other
     */
    public Polynom multPol(Polynom other){
        if(other != null){
            Polynom res = new Polynom();
            PolyNode p = _head;
            while (p!=null){
                PolyNode p1 = other._head;
                while (p1!=null){
                    double resco = (p.getCoefficient()*p1.getCoefficient());
                    int respow = (p.getPower()+p1.getPower());
                    PolyNode result = new PolyNode (respow, resco);
                    res.addNode(result);

                    p1 = p1.getNext();
                }
                p=p.getNext();
            }
            this._head = res._head;
        }

        return this;
    }

    /**
     * A method that calculates the derivative
     * and returns the derivative polynom
     * time complexity O(n)
     * space complexity O(1)
     */
    public Polynom differential(){
        PolyNode p = _head;
        PolyNode lastNode = _head;

        while (p!=null){
            if (p.getPower()>0){
                p.setCoefficient(p.getPower()*p.getCoefficient());
                p.setPower(p.getPower()-1);
            }
            else{
                lastNode.setNext(null);
            }
            lastNode = p;    
            p = p.getNext();   
        }

        return this;
    }

    /**
     * A method that returns to Polynom as a string
     * time complexity O(n)
     * space complexity O(1)
     */
    public String toString(){
        String res = "";
        PolyNode p = _head;
        while (p!=null){
            if (p.getCoefficient()>0){
                if(p!=_head && !res.equals(""))
                    res+="+"+p.toString();
                else
                    res+=p.toString();
            }
            else if (p.getCoefficient()!=0)
                res+=p.toString();
            p = p.getNext();
        }
        return res;

    }

}

