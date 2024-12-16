import com.fasterxml.jackson.databind.ObjectMapper;
import com.rescuegroups.Pet;
import edu.matc.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.util.Properties;

public class TestServiceClient implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());

    String url;
    String apiKey;
    String contentType;

    public void init() {

        Properties properties;

        try {
            properties = loadProperties("/rescuegroups.properties");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //url = properties.getProperty("url");
        //apiKey = properties.getProperty("apiKey");
        contentType = properties.getProperty("contentType");
    }

    @Test
    public void testswapiJSON() throws Exception {

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://api.rescuegroups.org/v5/public/animals/search/available/cats/haspic?fields[animals]=distance&include=breeds,colors,orgs,patterns,pictures,species&sort=animals.distance&limit=10");

        //String response = target.request(MediaType.APPLICATION_JSON).header("Authorization", "sodXODzJ").header("Content-Type", "application/vnd.api+json").get(String.class);

        //JSONObject mainJsonObject = new JSONObject(response);

        //ObjectMapper mapper = new ObjectMapper();

        //Pet pet = mapper.readValue(response, Pet.class);

        //pet.getData().get(1);

        /*try {
            // Make the API request and add necessary headers
            String response = target
                    .request(MediaType.APPLICATION_JSON)
                    .header("Authorization", apiKey)
                    .header("Content-Type", contentType)
                    .get(String.class);
            logger.info(response);

            if (response != null && !response.isEmpty()) {
                ObjectMapper mapper = new ObjectMapper();
                Pet pet = mapper.readValue(response, Pet.class);

                if (pet != null && pet.getData() != null && !pet.getData().isEmpty()) {
                    // Access and log the city of the first pet in the data
                    String city = pet.getData().get(0).getAttributes().getCity();
                    logger.info("City: " + city);
                } else {
                    logger.warn("No pet data found in the response.");
                }
            } else {
                logger.warn("Empty response received from the API.");
            }
        } catch (Exception e) {
            // Handle the exception (e.g., network errors, JSON parsing errors)
            logger.error("Error during API call or response processing", e);
        }*/

        //logger.info(pet.getData().get(0).getAttributes().getCity());


    }

}
