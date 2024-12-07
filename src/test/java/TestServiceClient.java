import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Pet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.DataInput;
import java.io.IOException;
import java.util.List;

public class TestServiceClient {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testswapiJSON() throws Exception {

        String baseUrl = "https://api.rescuegroups.org/v5";
        String apiKey = "sodXODzJ";

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(baseUrl + "/public/animals/search/available/cats/haspic?fields[animals]=distance&include=breeds,colors,orgs,pictures,species&sort=animals.distance&limit=50");
        //String stringResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);

        Response response = target.request(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + apiKey).header("Content-Type", "application/vnd.api+json").get();

        String responseBody = response.readEntity(String.class);

        JSONObject mainJsonObject = new JSONObject(response);

        logger.info(mainJsonObject);


    }

}
