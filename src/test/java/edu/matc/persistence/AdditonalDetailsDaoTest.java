package edu.matc.persistence;

import edu.matc.entity.Pet;
import edu.matc.entity.AdditionalDetails;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdditonalDetailsDaoTest {
    GenericDao petDao;
    GenericDao additionalDetailsDao;

    /**
     * Setup.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        petDao = new GenericDao(Pet.class);
        additionalDetailsDao = new GenericDao(AdditionalDetails.class);
    }

    /**
     * Verifies an additional detail is returned correctly based on its id.
     */
    @Test
    void getByIdSuccess() {
        AdditionalDetails retrievedAdditionalDetails = (AdditionalDetails) additionalDetailsDao.getById(4);
        assertNotNull(retrievedAdditionalDetails);
        assertEquals("I haven't had a cat in so long!", retrievedAdditionalDetails.getDetailsText());
    }

    /**
     * Gets all additional details success.
     */
    @Test
    void getAllAdditionalDetailsSuccess() {
        List<AdditionalDetails> additionalDetails = additionalDetailsDao.getAll();
        assertEquals(10, additionalDetails.size());
    }

    /**
     * Tests the update method.
     */
    @Test
    void saveOrUpdateSuccess() {
        String newAdditionalDetailsText = "Wait my dog was in the backyard the whole time!";
        AdditionalDetails additionalDetailsToUpdate = (AdditionalDetails) additionalDetailsDao.getById(4);
        additionalDetailsToUpdate.setDetailsText(newAdditionalDetailsText);
        additionalDetailsDao.update(additionalDetailsToUpdate);
        AdditionalDetails retrievedAdditionalDetails = (AdditionalDetails) additionalDetailsDao.getById(4);
        assertEquals(retrievedAdditionalDetails, additionalDetailsToUpdate);
    }

    /**
     * Tests the insert method.
     */
    @Test
    void insertSuccess() {

        Pet selectedPet = (Pet) petDao.getById(3);

        String additionalDetailsText = "Adding additonal details to pet with id: 3;";

        AdditionalDetails newAdditionalDetails = new AdditionalDetails(additionalDetailsText, selectedPet);
        selectedPet.addAdditionalDetails(newAdditionalDetails);

        int id = additionalDetailsDao.insert(newAdditionalDetails);

        assertNotEquals(0, id);
        AdditionalDetails insertedAdditionalDetails = (AdditionalDetails) additionalDetailsDao.getById(id);
        assertEquals(insertedAdditionalDetails, newAdditionalDetails);
    }

    /**
     * Tests the delete method.
     */
    @Test
    void deleteSuccess() {
        additionalDetailsDao.delete(additionalDetailsDao.getById(5));
        assertNull(additionalDetailsDao.getById(5));
    }

    /**
     * Tests the getByPropertyEqual method.
     */
    @Test
    void findByPropertyEqualSuccess() {
        List<AdditionalDetails> additionalDetailsList = additionalDetailsDao.getByPropertyEqual("detailsText", "I just hope the dog I get is energetic!");
        assertEquals(1, additionalDetailsList.size());
    }

}

