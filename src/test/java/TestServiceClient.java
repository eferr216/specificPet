import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testswapiJSON() throws Exception {

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://swapi.dev/api/planets/1");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        //logger.error(response);

        /*if (response.getStatus() == 200) {
            logger.error("We got a 200!");
        }
        else {
            logger.error("We did NOT get a 200..");
        }*/
        //assertEquals("???", response);
    }
}
