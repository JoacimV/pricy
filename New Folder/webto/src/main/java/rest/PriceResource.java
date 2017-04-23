package rest;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.priceCalc;

/**
 * REST Web Service
 *
 * @author joacim
 */
@Path("price")
public class PriceResource {
    
    Gson gson = new Gson();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PriceResource
     */
    public PriceResource() {
    }

    /**
     * Retrieves representation of an instance of rest.PriceResource
     * @param kg
     * @param country
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{kg}/{country}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("kg") String kg,@PathParam("country") String country) {
        return gson.toJson(new priceCalc().getPrice(country, kg));
    }

    /**
     * PUT method for updating or creating an instance of PriceResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
