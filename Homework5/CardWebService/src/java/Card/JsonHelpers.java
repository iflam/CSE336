/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Card;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;

/**
 *
 * @author giraf
 */
public class JsonHelpers {
    private static final String relativePath = "C:\\Users\\giraf\\Documents\\School\\CSE336\\Github\\CSE336\\Homework5\\CardWebService\\src\\java\\Card";
    private static CardObj[] createInitialJsonFile() throws FileNotFoundException{
        CardObj[] retCards = new CardObj[5];
        retCards[0] = 
            new CardObj(
                "123","Itai",
                "Flam","D",
                null,"123 Sesame Street",
                "West Hempstead","11552",
                "Email","itai.flam@stonybrook.edu",
                "111111111","111111111",
                true,new Date(7,15,1997),
                false,CardObj.Types.AD);
        retCards[1] = new CardObj(
                "124","Bob",
                "Dylan","F",
                "JR","111 Jjjj place",
                "Hicksville","11111",
                "Email","bob.dylan@music.org",
                "123456789","987654321",
                true,new Date(1,19,1950),
                false,CardObj.Types.SE);
        retCards[2] = new CardObj(
                "125","John",
                "Flam","P",
                null,"170 Hoola Hoop Drive",
                "Hurglesville","19191",
                "Email","HoopyHoopface@hoops.com",
                "000000000","000000000",
                true,new Date(8,8,1888),
                false,CardObj.Types.SE);
        retCards[3] = new CardObj(
                "126","Gloppy",
                "Tailspin","D",
                null,"Spinning Tails Blvd",
                "Stationaryville","11111",
                "Email","Gloopy@Tailspin.org",
                "808080808","808080808",
                true,new Date(6,16,2006),
                false,CardObj.Types.YA);
        retCards[4] = new CardObj(
                "127","Donald",
                "Trump","J",
                null,"1600 Pennsylvania Ave",
                "Washington DC","20500",
                "Email","yuge.wall@government.us",
                "696969696","969696969",
                true,new Date(6,14,1946),
                false,CardObj.Types.SE);
        return retCards;
    }
    public static CardObj MapJsonFileToCardObject(String cnum, String cname) throws IOException{
        CardObj[] retCards;
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File f = new File("C:\\cards.json");
        if(!f.exists()){
            f.createNewFile();
            retCards = createInitialJsonFile();
            mapper.writeValue(f,retCards);
            String jsonAsString = mapper.writeValueAsString(retCards);
        }
        retCards = mapper.readValue(f,CardObj[].class);
        for(CardObj c : retCards){
            if(c.LastName.equals(cname) && c.CardNumber.equals(cnum))
                return c;
        }
        //if none have that name and number
        return null;
    }
}   
