package edu.matc.controller;

import edu.matc.entity.AdditionalDetails;
import edu.matc.entity.Pet;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import edu.matc.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * This class is responsible for the interactions that occur between the database
 * and the data that is passed to it.
 */
public class SearchPetsHelper implements PropertiesLoader {
    GenericDao additionalDetailsDao = new GenericDao(AdditionalDetails.class);
    GenericDao petGenericDao = new GenericDao(Pet.class);
    GenericDao userDao = new GenericDao(User.class);
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * This method gets all of the pets associated with a userName.
     * @param req the HttpServletRequest
     * @return the userName
     */
    public String getUserPetRequests(HttpServletRequest req) {
        String userName = req.getParameter("user");
        List<User> users =  (List) userDao.getByPropertyEqual("userName", userName);
        Set<Pet> pets = users.get(0).getPetsSet();

        req.setAttribute("petRequests", pets);

        return userName;
    }

    /**
     * This method gets the additional details that are associated with any given pet.
     * @param req the HttpServletRequest
     */
    public void getSpecificPetAdditionalDetails(HttpServletRequest req)  {
        int petRequestId = Integer.parseInt(req.getParameter("petRequestId"));
        Pet selectedPet = (Pet) petGenericDao.getById(petRequestId);
        Set<AdditionalDetails> additionalDetailsSet = selectedPet.getAdditionalDetailsSet();

        req.setAttribute("selectedPet", selectedPet);
        req.setAttribute("additionalDetailsSet", additionalDetailsSet);
    }

    /**
     * This method searches the database for any pets that match the criteria as specified
     * by the user.
     * @param session the HttpSession
     * @param req the HttpServletRequest
     */
    public void searchForPets(HttpSession session, HttpServletRequest req) {
        String userName = (String) session.getAttribute("userName");

        // Check to see if userName session attribute is set
        if (userName != null) {
            List<User> users = (List) userDao.getByPropertyEqual("userName", userName);
            User currentUser = users.get(0);
            int currentUserId = currentUser.getId();
            req.setAttribute("currentUserId", currentUserId);
        }

        String petSpecies = getPetSpecies(req);

        int maxAnimalAge = Integer.parseInt(req.getParameter("maxAnimalAge"));
        String petColor = req.getParameter("petColor");
        int maxAnimalWeight = Integer.parseInt(req.getParameter("maxAnimalWeight"));

        Map<String, Object> criteria = new HashMap<>();
        criteria.put("petAge", maxAnimalAge);
        criteria.put("petSpecies", petSpecies);
        criteria.put("petColor", petColor);
        criteria.put("petWeight", maxAnimalWeight);

        List<User> pets = petGenericDao.getByPropertiesEqual(criteria);
        req.setAttribute("petRequests", pets);
    }

    /**
     * This method inserts a pet into the DB.
     * @param req the HttpServletRequest
     * @return the User
     */
    public User insertPet(HttpServletRequest req) {
        String userName = req.getParameter("user");
        List<User> users =  userDao.getByPropertyEqual("userName", userName);
        User currentUser = users.get(0);

        String petSpecies = getPetSpecies(req);
        int maxAnimalAge = Integer.parseInt(req.getParameter("maxAnimalAge"));
        String petColor = req.getParameter("petColor");
        int maxAnimalWeight = Integer.parseInt(req.getParameter("maxAnimalWeight"));

        Pet newPet = new Pet(maxAnimalAge, petSpecies, petColor, maxAnimalWeight, currentUser);
        petGenericDao.insert(newPet);

        List<Pet> pets = petGenericDao.getByPropertyEqual("user", currentUser);
        req.setAttribute("petRequests", pets);

        return currentUser;
    }

    /**
     * This method edits a Pet that is in the DB.
     * @param req the HttpServletRequest
     * @return the userName
     */
    public String editPet(HttpServletRequest req) {
        int selectedPetId = Integer.parseInt(req.getParameter("selectedPetId"));
        String userName = req.getParameter("user");
        User currentUser = getUserObjectFromUserName(userName);

        String petSpecies = getPetSpecies(req);
        String newPetColor = req.getParameter("petColor");
        int newMaxAnimalAge = Integer.parseInt(req.getParameter("maxAnimalAge"));
        int newMaxAnimalWeight = Integer.parseInt(req.getParameter("maxAnimalWeight"));

        Pet petToUpdate = (Pet) petGenericDao.getById(selectedPetId);

        petToUpdate.setPetSpecies(petSpecies);
        petToUpdate.setPetColor(newPetColor);
        petToUpdate.setPetAge(newMaxAnimalAge);
        petToUpdate.setPetWeight(newMaxAnimalWeight);

        petGenericDao.update(petToUpdate);

        List<Pet> pets = petGenericDao.getByPropertyEqual("user", currentUser);
        req.setAttribute("petRequests", pets);

        return userName;
    }

    /**
     * This method deletes a Pet from the DB.
     * @param req the HttpServletRequest
     * @return the userName
     */
    public String deletePet(HttpServletRequest req) {
        int selectedPetId = Integer.parseInt(req.getParameter("selectedPetId"));
        String userName = req.getParameter("user");
        User currentUser = getUserObjectFromUserName(userName);

        Pet selectedPet = (Pet) petGenericDao.getById(selectedPetId);

        petGenericDao.delete(selectedPet);

        List<Pet> pets = petGenericDao.getByPropertyEqual("user", currentUser);
        req.setAttribute("petRequests", pets);

        return userName;
    }

    /**
     * This method returns the chosen petSpecies.
     * @param req the HttpServletRequest
     * @return the petSpecies
     */
    private String getPetSpecies(HttpServletRequest req) {
        String petSpecies = "";
        if (req.getParameter("dogCheckbox") != null && req.getParameter("dogCheckbox").equals("Dog")) {
            petSpecies += req.getParameter("dogCheckbox");
        }
        if (req.getParameter("catCheckbox") != null && req.getParameter("catCheckbox").equals("Cat")) {
            petSpecies += req.getParameter("catCheckbox");
        }
        if (req.getParameter("turtleCheckbox") != null && req.getParameter("turtleCheckbox").equals("Turtle")) {
            petSpecies += req.getParameter("turtleCheckbox");
        }
        if (req.getParameter("birdCheckbox") != null && req.getParameter("birdCheckbox").equals("Bird")) {
            petSpecies += req.getParameter("birdCheckbox");
        }
        return petSpecies;
    }

    /**
     * This method sets a Pet object as a req attribute.
     * @param req the HttpServletReqest
     */
    public void getPetToEdit(HttpServletRequest req) {
        int selectedPetId = Integer.parseInt(req.getParameter("selectedPetId"));
        Pet petToEdit = (Pet) petGenericDao.getById(selectedPetId);
        req.setAttribute("petToEdit", petToEdit);
    }

    /**
     * This method returns a Pet according to a specific petId.
     * @param req the HttpServletRequest
     * @return a Pet
     */
    private Pet getPetObjectFromPetId(HttpServletRequest req) {
        int selectedPetId = Integer.parseInt(req.getParameter("selectedPetId"));
        Pet selectedPet = (Pet) petGenericDao.getById(selectedPetId);
        return selectedPet;
    }

    /**
     * This method returns a User object as specificed by a given userName.
     * @param userName the userName
     * @return a User
     */
    private User getUserObjectFromUserName(String userName) {
        List<User> users = userDao.getByPropertyEqual("userName", userName);
        User currentUser = users.get(0);
        return currentUser;
    }

    /**
     * This method inserts an additional details entry into the DB.
     * @param req the HttpServletRequest
     */
    public void insertAdditionalDetails(HttpServletRequest req) {
        Pet selectedPet = getPetObjectFromPetId(req);

        String additionalDetailsText = req.getParameter("additionalDetailsText");

        AdditionalDetails newAdditionalDetails = new AdditionalDetails(additionalDetailsText, selectedPet);
        selectedPet.addAdditionalDetails(newAdditionalDetails);

        additionalDetailsDao.insert(newAdditionalDetails);

        Set<AdditionalDetails> additionalDetailsSet = selectedPet.getAdditionalDetailsSet();

        req.setAttribute("selectedPet", selectedPet);
        req.setAttribute("additionalDetailsSet", additionalDetailsSet);
    }

    /**
     * This method deletes an additional details entry from the DB.
     * @param req the HttpServletRequest
     */
    public void deleteAdditionalDetails(HttpServletRequest req) {
        Pet selectedPet = getPetObjectFromPetId(req);

        int idToDelete = Integer.parseInt(req.getParameter("detailsId"));

        selectedPet.removeAdditionalDetails((AdditionalDetails) additionalDetailsDao.getById(idToDelete));

        additionalDetailsDao.delete(additionalDetailsDao.getById(idToDelete));

        Set<AdditionalDetails> additionalDetailsSet = selectedPet.getAdditionalDetailsSet();

        req.setAttribute("selectedPet", selectedPet);
        req.setAttribute("additionalDetailsSet", additionalDetailsSet);
    }

}

