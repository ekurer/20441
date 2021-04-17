/**
 * Task 12 - part 2
 * @Ephraim Kurer
 * @312265549
 */

public class FoodItem
{
    //decleration of variables.
    private String _name;
    private long _catalogueNumber;
    private int _quantity;
    private Date _productionDate;
    private Date _expiryDate;
    private int _minTemperature;
    private int _maxTemperature;
    private int _price;
    // decleration of finals 
    private final int ZERO_MIN_NUM = 0;
    private final int MIN_PRICE = 1;
    private final int MIN_QUANTITY = 0;
    private final int MIN_CATALOGUE_NUMBER = 1000;
    private final int MAX_CATALOGUE_NUMBER = 9999;

    /**
     * Constructor for food item object, creates a new FoodItem object.
     * @return creates a new FoodItem object.
     * @param name of the food
     * @param catalogueNumber catalogue number of food item
     * @param quantity quantity of food item
     * @param productionDate production date
     * @param expiryDate expiry date
     * @param minTemperature minimum storage temperature
     * @param maxTemperature maximum storage temperature
     * @param price unit price
     * Every food item has conditions to be valid, only valid parameters will be in used. otherwise, default 
     * values will be use instead.
     */
    public FoodItem(String name,long catalogueNumber,int quantity,Date productionDate,Date expiryDate,
    int minTemperature, int maxTemperature,int price)
    {
        if(name=="")
            _name = "item";
        else
            _name = name;

        if (catalogueNumber < MIN_CATALOGUE_NUMBER || catalogueNumber > MAX_CATALOGUE_NUMBER)
            _catalogueNumber = MAX_CATALOGUE_NUMBER;
        else 
            _catalogueNumber = catalogueNumber;

        if (quantity <= ZERO_MIN_NUM)
            _quantity = MIN_QUANTITY;   
        else 
            _quantity = quantity;  

        if(expiryDate.before(productionDate)){
            _productionDate = new Date(productionDate);
            _expiryDate = new Date(productionDate.tomorrow());
        }
        else {
            _expiryDate = expiryDate;
            _productionDate = productionDate;  
        }

        if(minTemperature > maxTemperature){
            int min,max;
            min = minTemperature;
            max = maxTemperature;
            _minTemperature = max;
            _maxTemperature = min;
        }
        else{
            _minTemperature = minTemperature;
            _maxTemperature = maxTemperature;
        }

        if (price <= ZERO_MIN_NUM)
            _price = MIN_PRICE; 
        else 
            _price = price;
    }

    /**
     * 
     * @return copy constructor as a new object
     * @param FoodItem other - the food item to be copied
     */
    public FoodItem(FoodItem other)
    {        
        this._name = other._name;
        this._catalogueNumber = other._catalogueNumber;
        this._quantity = other._quantity;
        this._productionDate = new Date(other._productionDate);
        this._expiryDate = new Date(other._expiryDate);
        this._minTemperature = other._minTemperature;
        this._maxTemperature = other._maxTemperature;
        this._price = other._price;        
    }

    /** 
     * gets the name
     * @return the name
     */
    //This methood was created in order to recieve the name of the food item.
    public String getName(){
        return(_name);        
    }

    /** 
     * gets the catalogue number
     * @return the catalogue number
     */
     //This methood was created in order to recieve the value of the catalogue number of the item.
    public long getCatalogueNumber(){
        return(_catalogueNumber);        
    }

    /** 
     * gets the quantity
     * @return the quantity .
     */
    //This methood was created in order to recieve the quantity of the item
    public int getQuantity(){
        return(_quantity);        
    }

    /** 
     * gets the production date
     * @return the production date.
     */
    //This methood was created in order to recieve the the production date of the item
    public Date getProductionDate(){
        return new Date(_productionDate); 
    }

    /** 
     * gets the expiry date
     * @return the expiry date.
     */
    //This methood was created in order to recieve the value of the expiry date of the item
    public Date getExpiryDate(){
        return new Date(_expiryDate); 
    }

    /** 
     * gets the minimum storage temperature
     * @return the minimum storage temperature.
     */
    //This methood was created in order to recieve the value of the minimun storage temperature for the item.
    public int getMinTemperature(){
        return(_minTemperature); 
    }

    /** 
     * gets the maximum storage temperature
     * @return the maximum storage temperature.
     */
    //This methood was created in order to recieve the value of the maximum storage temperature for the item.
    public int getMaxTemperature(){
        return(_maxTemperature); 
    }

    /** 
     * gets the unit price
     * @return the unit price.
     */
    //This methood was created in order to recieve the price of the item.
    public int getPrice(){
        return(_price); 
    }

    /** 
     * set the quantity (only if not negative)
     * @param int number the quantity value to be set.
     */ 
    //This methood was created in order to allow users to change the quantity of the FoodItem object.
    public void setQuantity(int num){
        if(num >= 0)
            _quantity = num;
        else 
            _quantity = _quantity; 
    }

    /** 
     * set the production date (only if not after expiry date )
     * @param d production date value to be set
     */ 
    //This methood was created in order to allow users to change the production date of the FoodItem object.
    public void setProductionDate(Date d){
        if(d.before(_expiryDate))
            _productionDate = new Date(d);
        else 
            _productionDate = _productionDate;
    }

    /** 
     * set the expiry date (only if not before production date )
     * @param d expiry date value to be set
     */ 
    //This methood was created in order to allow users to change the expiry date of the FoodItem object.
    public void setExpiryDate (Date d){
        if (d.after(_productionDate))
            _expiryDate = new Date(d);    
        else 
            _expiryDate = _expiryDate;
    }

    /** 
     * set the price (only if positive)
     * @param int p price to be set 
     */
    //This methood was created in order to allow users to change the unit price of the FoodItem object.
    public void setPrice(int p){
        if(p>0)
            _price = p; 
        else 
            _price = _price;
    }

    /** 
     * check if this food item is fresh on the date d
     * @param d date to check
     * @return true if this food item is fresh on the date "d"
     */
    //This methood was created in order to allow users to check if this food item is fresh on the date "d"
    public boolean isFresh(Date d){
        if(this._productionDate.before(d) && this._expiryDate.after(d) ||
        this._productionDate.equals(d) && this._expiryDate.after(d) || 
        this._productionDate.equals(d) && this._expiryDate.equals(d)||
        this._productionDate.before(d) && this._expiryDate.equals(d))  
            return true;        
        else
            return false;        
    }

    /** 
     * check if this food item is older than other food item
     * @param other food item to compare this food item to
     * @return true if this food item is older than other food item date
     */
    //This methood was created in order to allow users to check if this food item is older than other food item
    public boolean olderFoodItem(FoodItem other){
        if(this._productionDate.before(other._productionDate)==true)  
            return true;
        else
            return false;   
    }

    /** 
     * check if 2 food items are the same (excluding the quantity values)
     * @param other the food item to compare this food item to
     * @return true if the food items are the same
     */
    //This methood was created in order to allow users to check if 2 food items are the same (excluding the quantity values)
    public boolean equals(FoodItem other){      
        if(this._name.equals(other._name) &&
        this._catalogueNumber == other._catalogueNumber && this._productionDate.equals(other._productionDate)
        && this._expiryDate.equals(other._expiryDate) &&
        this._minTemperature == other._minTemperature && this._maxTemperature == other._maxTemperature &&
        this._price == other._price)
            return true; 
        else return false;
    }

    /** 
     * returns a String that represents this food item
     * @return String that represents this food item in the following format:
     * FoodItem: milk CatalogueNumber: 1234 ProductionDate: 14/12/2019 ExpiryDate: 21/12/2019 Quantity: 3 
     */
    //This methood was created in order to allow users to recieve a String that represents this food item
    public String toString(){
        String s = "" ;
        s+= "FoodItem: " + _name + "\tCatalogueNumber: " + _catalogueNumber + "\tProductionDate: " +
        _productionDate.toString() + "\tExpiryDate: " + _expiryDate.toString() + "\tQuantity: " + 
        _quantity;    
        return s;
    }

    /** 
     * returns the number of units of products that can be purchased for a given amount
     * @param amount amount to purchase
     * @return the number of units can be purchased
     */
    //This methood was created in order to allow users to recieve the number of units of products that can 
    // be purchased for a given amount
    public int howManyItems(int moneyAmount){
        if(moneyAmount <= ZERO_MIN_NUM)
            return ZERO_MIN_NUM;
        else if (_price <= ZERO_MIN_NUM)
            return ZERO_MIN_NUM;
        if((moneyAmount/_price) < _quantity)
            return moneyAmount/_price;
        else
            return _quantity;           
    }

    /** 
     * check if this food item is cheaper than other food item
     * @param other food item to compare this food item to
     * @return true if this food item is cheaper than other food item
     */
    //This methood was created in order to allow users to check if this food item is cheaper than other food item
    public boolean isCheaper(FoodItem other){
        if(_price < other._price)
            return true;
        else 
            return false;        
    }
}