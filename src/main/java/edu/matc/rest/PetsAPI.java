package edu.matc.rest;

import edu.matc.entity.Pet;
import edu.matc.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/pets")
public class PetsAPI {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/html"
    @Produces("application/json")
    public Response getMesssage() {
        GenericDao petDao = new GenericDao(Pet.class);
        String output = "[";

        List<Pet> pets = petDao.getAll();

        for (Pet pet : pets) {
            output += "{\"Pet Id\": " + pet.getId()
                    + ", \"Pet Age\": " + pet.getPetAge()
                    + ", \"Pet Weight\": " + pet.getPetWeight()
                    + ", \"Pet Species\": \"" + pet.getPetSpecies()
                    + "\", \"Pet Color\": \"" + pet.getPetColor()
                    + "\"}, ";
        }

        // Remove the last 2 characters from the output; the comma and empty space
        if (output.length() > 2) {
            output = output.substring(0, output.length() - 2);  // Remove the last 2 characters
        }

        output += "]";

        return Response.status(200).entity(output).build();
    }

}
