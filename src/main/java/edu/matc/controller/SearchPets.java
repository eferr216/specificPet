package edu.matc.controller;

import edu.matc.entity.AdditionalDetails;
import edu.matc.entity.Pet;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpSession;


/**
 * The servlet is responsible for performing all of the CRUD operations on our DB.
 */

@WebServlet(
        urlPatterns = {"/searchPets"}
)
public class SearchPets extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        GenericDao petGenericDao = new GenericDao(Pet.class);
        String clickedLink = req.getParameter("link");

        if (clickedLink.equals("petRequests")) {
            req.setAttribute("petRequests", petGenericDao.getAll());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewrequests.jsp");
            dispatcher.forward(req, res);
        }
        else if (clickedLink.equals("viewAdditionalDetails")) {
            int petRequestId = Integer.parseInt(req.getParameter("petRequestId"));

            Pet selectedPet = (Pet) petGenericDao.getById(petRequestId);

            Set<AdditionalDetails> additionalDetailsSet = selectedPet.getAdditionalDetailsSet();

            req.setAttribute("selectedPet", selectedPet);
            req.setAttribute("additionalDetailsSet", additionalDetailsSet);


            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewadditionaldetails.jsp");
            dispatcher.forward(req, res);
        }
        else if (clickedLink.equals("addNewAdditionalDetails")) {
            int petRequestId = Integer.parseInt(req.getParameter("selectedPetId"));

            Pet selectedPet = (Pet) petGenericDao.getById(petRequestId);

            Set<AdditionalDetails> additionalDetailsSet = selectedPet.getAdditionalDetailsSet();

            req.setAttribute("selectedPet", selectedPet);
            req.setAttribute("additionalDetailsSet", additionalDetailsSet);


            RequestDispatcher dispatcher = req.getRequestDispatcher("/addadditionaldetails.jsp");
            dispatcher.forward(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        GenericDao petGenericDao = new GenericDao(Pet.class);
        GenericDao additionalDetailsDao = new GenericDao(AdditionalDetails.class);
        GenericDao userDao = new GenericDao(User.class);

        if (req.getParameter("searchForPetsButton") != null) {
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

            int maxAnimalAge = Integer.parseInt(req.getParameter("maxAnimalAge"));
            String petColor = req.getParameter("petColor");
            int maxAnimalWeight = Integer.parseInt(req.getParameter("maxAnimalWeight"));

            /////////////////////////////////////

            //req.setAttribute("petRequests", petGenericDao.getAll());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewrequests.jsp");
            dispatcher.forward(req, res);
        }
        else if (req.getParameter("insertPetRequestButton") != null) {
            String petSpecies = "";
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");

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

            int maxAnimalAge = Integer.parseInt(req.getParameter("maxAnimalAge"));
            String petColor = req.getParameter("petColor");
            int maxAnimalWeight = Integer.parseInt(req.getParameter("maxAnimalWeight"));

            Pet newPet = new Pet(maxAnimalAge, petSpecies, petColor, maxAnimalWeight);

            petGenericDao.insert(newPet);

            req.setAttribute("petRequests", petGenericDao.getAll());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewrequests.jsp");
            dispatcher.forward(req, res);
        }
        else if (req.getParameter("insertAdditionalDetailsButton") != null) {
            int selectedPetId = Integer.parseInt(req.getParameter("selectedPetId"));
            Pet selectedPet = (Pet) petGenericDao.getById(selectedPetId);

            String additionalDetailsText = req.getParameter("additionalDetailsText");

            AdditionalDetails newAdditionalDetails = new AdditionalDetails(additionalDetailsText, selectedPet);
            selectedPet.addAdditionalDetails(newAdditionalDetails);

            additionalDetailsDao.insert(newAdditionalDetails);

            Set<AdditionalDetails> additionalDetailsSet = selectedPet.getAdditionalDetailsSet();

            req.setAttribute("selectedPet", selectedPet);
            req.setAttribute("additionalDetailsSet", additionalDetailsSet);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewadditionaldetails.jsp");
            dispatcher.forward(req, res);
        }
        else if (req.getParameter("deleteDetails") != null) {
            int selectedPetId = Integer.parseInt(req.getParameter("selectedPetId"));
            Pet selectedPet = (Pet) petGenericDao.getById(selectedPetId);

            int idToDelete = Integer.parseInt(req.getParameter("detailsId"));

            selectedPet.removeAdditionalDetails((AdditionalDetails) additionalDetailsDao.getById(idToDelete));

            additionalDetailsDao.delete(additionalDetailsDao.getById(idToDelete));

            Set<AdditionalDetails> additionalDetailsSet = selectedPet.getAdditionalDetailsSet();

            req.setAttribute("selectedPet", selectedPet);
            req.setAttribute("additionalDetailsSet", additionalDetailsSet);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewadditionaldetails.jsp");
            dispatcher.forward(req, res);
        }
        else if (req.getParameter("deleteRequest") != null) {
            int selectedPetId = Integer.parseInt(req.getParameter("selectedPetId"));
            Pet selectedPet = (Pet) petGenericDao.getById(selectedPetId);

            petGenericDao.delete(selectedPet);

            List<Pet> petRequests = petGenericDao.getAll();

            req.setAttribute("petRequests", petRequests);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewrequests.jsp");
            dispatcher.forward(req, res);
        }
        else if (req.getParameter("editRequest") != null) {
            int selectedPetId = Integer.parseInt(req.getParameter("selectedPetId"));
            Pet petToEdit = (Pet) petGenericDao.getById(selectedPetId);
            req.setAttribute("petToEdit", petToEdit);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/editrequest.jsp");
            dispatcher.forward(req, res);
        }
        else if (req.getParameter("confirmEditRequestButton") != null) {
            int idToEdit = Integer.parseInt(req.getParameter("idToEdit"));
            String newPetColor = req.getParameter("petColor");
            int newMaxAnimalAge = Integer.parseInt(req.getParameter("maxAnimalAge"));
            int newMaxAnimalWeight = Integer.parseInt(req.getParameter("maxAnimalWeight"));

            Pet petToUpdate = (Pet) petGenericDao.getById(idToEdit);

            petToUpdate.setPetColor(newPetColor);
            petToUpdate.setPetAge(newMaxAnimalAge);
            petToUpdate.setPetWeight(newMaxAnimalWeight);

            petGenericDao.update(petToUpdate);

            logger.info(petToUpdate);

            req.setAttribute("petRequests", petGenericDao.getAll());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewrequests.jsp");
            dispatcher.forward(req, res);
        }

    }
}
