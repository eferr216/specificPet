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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Begins the authentication process using AWS Cognito
 *
 */
public class SearchPetsHelper implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public String getUserPetRequests(HttpServletRequest req, GenericDao userDao) {
        String userName = req.getParameter("user");
        List<User> users =  (List) userDao.getByPropertyEqual("userName", userName);
        Set<Pet> pets = users.get(0).getPetsSet();

        req.setAttribute("petRequests", pets);

        return userName;
    }

    public void getSpecificPetAdditionalDetails(HttpServletRequest req, GenericDao petGenericDao)  {
        int petRequestId = Integer.parseInt(req.getParameter("petRequestId"));
        Pet selectedPet = (Pet) petGenericDao.getById(petRequestId);
        Set<AdditionalDetails> additionalDetailsSet = selectedPet.getAdditionalDetailsSet();

        req.setAttribute("selectedPet", selectedPet);
        req.setAttribute("additionalDetailsSet", additionalDetailsSet);
    }

    public void searchForPets(HttpSession session, GenericDao userDao, HttpServletRequest req, GenericDao petGenericDao) {
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

    public User insertPet(HttpServletRequest req, GenericDao userDao, GenericDao petGenericDao) {
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

    public String editPet(HttpServletRequest req, GenericDao userDao, GenericDao petGenericDao) {
        int selectedPetId = Integer.parseInt(req.getParameter("selectedPetId"));
        String userName = req.getParameter("user");
        User currentUser = getUserObjectFromUserName(userName, userDao);

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

    public String deletePet(HttpServletRequest req, GenericDao userDao, GenericDao petGenericDao) {
        int selectedPetId = Integer.parseInt(req.getParameter("selectedPetId"));
        String userName = req.getParameter("user");
        User currentUser = getUserObjectFromUserName(userName, userDao);

        Pet selectedPet = (Pet) petGenericDao.getById(selectedPetId);

        petGenericDao.delete(selectedPet);

        List<Pet> pets = petGenericDao.getByPropertyEqual("user", currentUser);
        req.setAttribute("petRequests", pets);

        return userName;
    }

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

    public void getPetToEdit(HttpServletRequest req, GenericDao petGenericDao) {
        int selectedPetId = Integer.parseInt(req.getParameter("selectedPetId"));
        Pet petToEdit = (Pet) petGenericDao.getById(selectedPetId);
        req.setAttribute("petToEdit", petToEdit);
    }

    private User getUserObjectFromUserName(String userName, GenericDao userDao) {
        List<User> users = userDao.getByPropertyEqual("userName", userName);
        User currentUser = users.get(0);
        return currentUser;
    }

    public void insertAdditionalDetails(HttpServletRequest req, GenericDao petGenericDao, GenericDao additionalDetailsDao) {
        int selectedPetId = Integer.parseInt(req.getParameter("selectedPetId"));
        Pet selectedPet = (Pet) petGenericDao.getById(selectedPetId);

        String additionalDetailsText = req.getParameter("additionalDetailsText");

        AdditionalDetails newAdditionalDetails = new AdditionalDetails(additionalDetailsText, selectedPet);
        selectedPet.addAdditionalDetails(newAdditionalDetails);

        additionalDetailsDao.insert(newAdditionalDetails);

        Set<AdditionalDetails> additionalDetailsSet = selectedPet.getAdditionalDetailsSet();

        req.setAttribute("selectedPet", selectedPet);
        req.setAttribute("additionalDetailsSet", additionalDetailsSet);
    }

    public void deleteAdditionalDetails(HttpServletRequest req, GenericDao petGenericDao, GenericDao additionalDetailsDao) {
        int selectedPetId = Integer.parseInt(req.getParameter("selectedPetId"));
        Pet selectedPet = (Pet) petGenericDao.getById(selectedPetId);

        int idToDelete = Integer.parseInt(req.getParameter("detailsId"));

        selectedPet.removeAdditionalDetails((AdditionalDetails) additionalDetailsDao.getById(idToDelete));

        additionalDetailsDao.delete(additionalDetailsDao.getById(idToDelete));

        Set<AdditionalDetails> additionalDetailsSet = selectedPet.getAdditionalDetailsSet();

        req.setAttribute("selectedPet", selectedPet);
        req.setAttribute("additionalDetailsSet", additionalDetailsSet);
    }

}

