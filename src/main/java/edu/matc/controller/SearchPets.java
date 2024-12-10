package edu.matc.controller;

import edu.matc.entity.AdditionalDetails;
import edu.matc.entity.Pet;
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
import java.util.Set;
import javax.servlet.http.HttpSession;


/**
 * A simple servlet to welcome the user
 */

@WebServlet(
        urlPatterns = {"/searchPets"}
)
public class SearchPets extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        GenericDao petGenericDao = new GenericDao(Pet.class);
        GenericDao additionalDetailsDao = new GenericDao(AdditionalDetails.class);
        String clickedLink = req.getParameter("link");

        if (req.getParameter("dogCheckbox") != null) {
            logger.error("Fake error!");
        }
        else if (clickedLink.equals("petRequests")) {
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
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        GenericDao petGenericDao = new GenericDao(Pet.class);

        if (req.getParameter("insertPetRequestButton") != null) {

            logger.error("submit request button being pressed...");

            /*int petAge = 0;
            int petWeight = 0;
            if (req.getParameter("minAnimalAge") != null) {
                petAge = Integer.parseInt(req.getParameter("petAge"));
            }
            String petSpecies = req.getParameter("petSpecies");
            String petColor = req.getParameter("petColor");
            if (req.getParameter("minAnimalWeight") != null) {
                petWeight = Integer.parseInt(req.getParameter("petWeight"));
            }

            Pet newPet = new Pet();

            newPet.setPetAge(petAge);
            newPet.setPetSpecies(petSpecies);
            newPet.setPetColor(petColor);
            newPet.setPetWeight(petWeight);

            petGenericDao.insert(newPet);*/

            req.setAttribute("pets", petGenericDao.getAll());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/makerequest.jsp");
            dispatcher.forward(req, res);
        }
        /*else if (req.getParameter("confirmDeleteDetails") != null) {
            int selectedPetId = Integer.parseInt(req.getParameter("selectedPetId"));
            Pet selectedPet = (Pet) petGenericDao.getById(selectedPetId);

            int idToDelete = Integer.parseInt(req.getParameter("item_note_id"));

            selectedItem.removeItemNote((ItemNote) itemNoteGenericDao.getById(idToDelete));

            itemNoteGenericDao.delete(itemNoteGenericDao.getById(idToDelete));

            Set<ItemNote> itemNotesList = selectedItem.getItemNotes();

            req.setAttribute("selectedItem", selectedItem);
            req.setAttribute("itemNotes", itemNotesList);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/itemNotes.jsp");
            dispatcher.forward(req, res);
        }*/
    }
}
