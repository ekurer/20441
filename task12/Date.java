
/**
 * Task 12 - part 1
 * @Ephraim Kurer
 * @312265549
 */

public class Date
{
    //decleration of instance variables
    private int _day;
    private int _month;
    private int _year;
    private int day, month, year;
    // decleration of finals
    private final int DEFAULT_DAY = 1;
    private final int DEFAULT_MONTH = 1;
    private final int DEFAULT_YEAR = 2000; 
    private final int MAX_DAYS_IN_MONTH= 31;
    private final int MAX_DAYS_IN_FEBRUARY= 28;
    private final int MAX_MONTH = 12;
    private final int MIN_YEAR = 1000;
    private final int MAX_YEAR = 9999;
    private final int LEAP_YEAR_EVERY_4 = 4;// leap year happens every 4 years.
    private final int LEAP_YEAR_NOT_100 = 100;
    private final int LEAP_YEAR_DIVIDED_BY_400 = 400;

    /**
     * creates a new Date object if the date is valid, otherwise creates default date (1/1/2000)
     * @param int day
     * @param int month
     * @param int year
     * @return a new Date object
     */
    // Constructs a Date object.
    // The date entered must create a valid date, otherwise will get default 1/1/2000
    // Construct a new date instance with the given day ,month and year.
    public Date(int day, int month, int year){ // date constructor
        if(validDate(day,month,year) == true){
            _day = day;
            _month = month;
            _year = year;
        }
        else {
            _day = DEFAULT_DAY;
            _month = DEFAULT_MONTH;
            _year = DEFAULT_YEAR;
        }
    }

    /**
     * copy constructor
     * @param date other
     * @return a copy of the Date object.
     */

    public Date(Date other)
    { 
        this._day = other._day;
        this._month = other._month;
        this._year = other._year;        
    }

    /*
     * Private boolean methood for validation of dates.
     * wrong cases will return false and will impact the creation of a date object in the constructor.
     * @param day 
     * @param month
     * @param year
     * @return true or false for valid or unvalid date.
     * This methood is using switch methood in order to specific several options for all 12 months and days in each one,
     * including a leap year cases and other.
     * I used finals to represent the numbers.
     */    
    private boolean validDate(int day,int month,int year){
        if (month<DEFAULT_MONTH || month>MAX_MONTH||day<DEFAULT_DAY
        ||day>MAX_DAYS_IN_MONTH || year>MAX_YEAR||year<MIN_YEAR)
            return false;
        else
            switch(month){ 
                case 2: if(day<=MAX_DAYS_IN_FEBRUARY)
                    return true;
                else if((day==MAX_DAYS_IN_FEBRUARY+1) && ((year%LEAP_YEAR_EVERY_4==0)
                    && (year%LEAP_YEAR_NOT_100 != 0)) || ((day==MAX_DAYS_IN_FEBRUARY+1)&& 
                    (year%LEAP_YEAR_DIVIDED_BY_400==0))) 
                    return true;
                else return false;                   
                case 4:
                case 6:
                case 9:
                case 11: if(day>(MAX_DAYS_IN_MONTH-1))
                    return false;
                else return true;  
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: if(day>(MAX_DAYS_IN_MONTH))
                    return false;
                else return true; 
            }
        return true;
    }

    /** 
     * gets the day
     * @return the day.
     */
    public int getDay(){
        return (_day);
    }

    /** 
     * gets the month.
     * @return the month.
     */ 
    public int getMonth(){
        return (_month);
    }

    /** 
     * gets the year.
     * @return the year.
     * 
     */ 
    public int getYear(){
        return (_year);
    }

    /** 
     * sets the day (only if date remains valid)
     * @param int dayToSet.
     */ 
    public void setDay(int dayToSet){
        if (validDate(dayToSet,this._month,this._year)==true)
        {
            this._day = dayToSet;
            this._month = _month;
            this._year = _year;
        }
        else 
            _day = _day;
    }

    /** 
     * set a new month to the date (only if the date will remain valid).
     * @param int monthToSet.
     */ 
    public void setMonth(int monthToSet){
        if(validDate(this._day,monthToSet,this._year) == true){
            this._day = _day;
            this._month = monthToSet;
            this._year = _year;
        }
        else 
            _month = _month;
    }

    /** 
     * set a new year to the date(only if the date will remain valid).
     * @param int yearToSet.
     */ 
    public void setYear(int yearToSet){
        if(validDate(this._day,this._month,yearToSet) == true)
        {
            this._day = _day;
            this._month = _month;
            this._year = yearToSet;
        }
        else 
            _year = _year;
    } 

    /** 
     * check if 2 dates are the same
     * @param Date other.
     * @return true if 2 dates are the same else false.
     */
    public boolean equals(Date other){
        if(this._day==other._day&&this._month==other._month&&this._year==other._year)
            return true;
        else 
            return false;     
    }

    /** 
     * Checks if this date object is before the other date
     * @param Date other
     * @return true if this date before other date else false
     */
    public boolean before(Date other){
        if(this._year < other._year)
            return true;       
        else if((this._year == other._year)&&(this._month < other._month))
            return true;
        else if((this._year == other._year)&&(this._month == other._month)&&(this._day < other._day))
            return true;
        else 
            return false; 
    }

    /**
     * Checks if this date object is after the other date 
     * @param Date other.
     * @return true if this date after other date else false
     */
    public boolean after(Date other){
        return other.before(this);
    }

    /** Private methood calculateDate.
     * @param int day, month, year.
     * Calculates by equation the day from the begining of the year by a given equation.
     * We created this private methood to help us in other methood(difference).
     */
    private int calculateDate(int day, int month, int year){
        if (month < 3) 
        {
            year--;
            month = month + 12; 
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    }

    /** 
     * calculates the difference in days between two dates
     * @param other the date calculate the difference between
     * @return the number of days between the dates
     */
    // This methood was created in order to allow users to calculate the difference between 2 dates.
    public int difference(Date other){          
        int d1 = Math.abs(calculateDate(this._day,this._month,this._year)-
                calculateDate(other._day,other._month,other._year));
        return d1;
    }

    /** 
     * returns a String that represents this date
     * @return String that represents this date in the following format: d/m/y (01/01/2019)
     */
    // This methood was created in order to allow users to output the date object values as a string.
    public String toString(){
        String s = "" ;
        if(_day<10 && _month<10)
            s+= "0" + _day + "/" +"0" + _month + "/" + _year;
        else if(_day<10 && _month>=10)
            s+= "0" + _day + "/" + _month + "/" + _year;
        else if(_day>=10 && _month<10)
            s+= _day + "/" + "0" + _month + "/" + _year;
        else if(_day>=10 && _month>=10)  
            s+= _day + "/" + _month + "/" + _year; 
        return s;
    }

    /** 
     * calculate the date of tomorrow
     * @return the date of tomorrow
     * 
     */
    public Date tomorrow(){
        if((validDate(this._day+1,this._month,this._year)==true)){
            return new Date((this._day+1),(this._month),(this._year));}
        else if ((validDate(1,_month+1,_year)==true)){
            return new Date(1,_month+1,_year);}
        else if((validDate(this._day+1,this._month,this._year)!=true) && ((validDate(1,_month+1,_year)!=true))
        && (validDate(1,1,_year+1)!=true))
            return new Date(1,1,2000);
        else 
            return new Date(1,1,_year+1);
    }

    /** 
     * calculate the day of the week
     * @return the day of the week
     * 
     */
    public int dayInWeek(){
        int day, d,m,y;
        d = _day;
        m = _month;
        y = _year;
        if(_month ==1){
            y=y-1;
            m = 13;
            day = (d + (26*(m+1))/10 + y%100 + (y%100)/4 +
                (y/100)/4 - 2*(y/100)) ;
            day =Math.floorMod(day,7);    
            return day;
        }
        else if(_month ==2){
            y=y-1;
            m = 14;
            day = (d + (26*(m+1))/10 + y%100 + (y%100)/4 +
                (y/100)/4 - 2*(y/100));
            day=Math.floorMod(day,7);  
            return day;
        }               
        else {
            day = (d + (26*(m+1))/10 + y%100 + (y%100)/4 +
                (y/100)/4 - 2*(y/100));            
            day=Math.floorMod(day,7);  
            return day;            
        }
    }
}
