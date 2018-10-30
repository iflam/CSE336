/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Card;

import static Card.JsonHelpers.MapJsonFileToCardObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author giraf
 */
@Path("Cards")
public class CardsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CardsResource
     */
    public CardsResource() {
    }

    /**
     * Retrieves representation of an instance of Card.CardsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of CardsResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
//    @POST
//    @Path("/AddCard")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void addCard(CardObj c){
//        System.out.println("Hello there.");
//    }
    
    @GET
    @Path("{cnum}/{cname}")
    @Produces(MediaType.APPLICATION_JSON)
    public String cardInfo(@PathParam("cnum") int cnum, @PathParam("cname") String cname){
        CardObj myCard = null;
        try{
            myCard = MapJsonFileToCardObject(cnum+"",cname);
        }
        catch(IOException e){
            System.out.println("Could not open file.");
        }
        if(myCard != null){
            ObjectMapper mapper = new ObjectMapper();
            try{
            return mapper.writeValueAsString(myCard);
            }
            catch(IOException e){
            }
        }
        return "";
    }
}
