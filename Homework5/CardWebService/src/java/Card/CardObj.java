/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Card;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author giraf
 */
@XmlRootElement
public class CardObj{

    public CardObj(String CardNumber, String FirstName, String LastName, String City) {
        this.CardNumber = CardNumber;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.City = City;
    }

    public CardObj(String CardNumber, String FirstName, 
            String LastName, String MiddleIn, 
            String Suffix, String StreetAddress, 
            String City, String Zipcode, 
            String NoticePreference, String Email, 
            String Phone, String Cell, 
            boolean GetsNews, Date Birthdate, 
            boolean WillPickUp, Types CardTypes) {
        this.CardNumber = CardNumber;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.MiddleIn = MiddleIn;
        this.Suffix = Suffix;
        this.StreetAddress = StreetAddress;
        this.City = City;
        this.Zipcode = Zipcode;
        this.NoticePreference = NoticePreference;
        this.Email = Email;
        this.Phone = Phone;
        this.Cell = Cell;
        this.GetsNews = GetsNews;
        this.Birthdate = Birthdate;
        this.WillPickUp = WillPickUp;
        this.CardTypes = CardTypes;
    }
    public String CardNumber;
    public String FirstName;
    public String LastName;
    public String MiddleIn;
    public String Suffix;
    public String StreetAddress;
    public String City;
    public String Zipcode;
    public String NoticePreference;
    public String Email;
    public String Phone;
    public String Cell;
    public boolean GetsNews;
    public Date Birthdate;
    public boolean WillPickUp;
    /**
     * Types are: YA (young adult), AD (Adult), SE (Senior)
     */
    public static enum Types{YA,AD,SE};
    public Types CardTypes;
    
    public CardObj(){
        
    }
    
}
