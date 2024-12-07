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
    @Produces("text/plain")
    public Response getMesssage() {
        GenericDao petDao = new GenericDao(Pet.class);
        String output = "";

        List<Pet> pets = petDao.getAll();

        for (Pet pet : pets) {
            output += "Pet Age: " + pet.getPetAge()
                    + ", Pet Weight: " + pet.getPetWeight()
                    + ", Pet Species: " + pet.getPetSpecies()
                    + ", Pet Color: " + pet.getPetColor();
        }

        return Response.status(200).entity(output).build();
    }

}
