package edu.matc.persistence;

import edu.matc.entity.Pet;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class PetDaoTest {

    /**
     * The Dao.
     */
    GenericDao petDao;

    /**
     * Sets up the book table with fresh data, and instantiates the bookdao.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        petDao = new GenericDao<>(Pet.class);
    }

    /**
     * Verifies getById successfully runs.
     */
    @Test
    void getByIdSuccess() {
        Pet retrievedPet = (Pet) petDao.getById(3);
        assertEquals("Cat", retrievedPet.getPetSpecies());
        assertEquals("yellow", retrievedPet.getPetColor());
    }

    /**
     * Insert.
     */
    @Test
    void insertSuccess() {
        Pet petToInsert = new Pet(88, "Bird","Multi-color", 1906);
        int insertedPetId = petDao.insert(petToInsert);
        assertNotEquals(0, insertedPetId);
        Pet insertedPet = (Pet) petDao.getById(insertedPetId);
        assertEquals("Bird", insertedPet.getPetSpecies());

    }

    /**
     * Save or update.
     */
    @Test
    void updateSuccess() {
        Pet petToUpdate = (Pet) petDao.getById(1);
        petToUpdate.setPetAge(9);
        petDao.update(petToUpdate);

        Pet actualPet = (Pet) petDao.getById(1);
        assertEquals(9, actualPet.getPetAge());

    }

    /**
     * Delete.
     */
    @Test
    void deleteSuccess() {
        petDao.delete(petDao.getById(2));
        assertNull(petDao.getById(2));
    }

    /**
     * Gets all.
     */
    @Test
    void getAllSuccess() {
        List<Pet> pets = petDao.getAll();
        assertEquals(10, pets.size());
    }

    /**
     * Get by specific value.
     */
    @Test
    void getByPropertyEqual() {
        List<Pet> pets = petDao.getByPropertyEqual("petColor", "grey");
        assertEquals(1, pets.size());
        assertEquals(10, pets.get(0).getId());
    }

    /**
     * Get by value that is is LIKE a specified value.
     */
    @Test
    void getByPropertyLike() {
        List<Pet> pets = petDao.getByPropertyEqual("petSpecies", "bird");
        assertEquals(1, pets.size());
        assertEquals(9, pets.get(0).getId());
    }

}
