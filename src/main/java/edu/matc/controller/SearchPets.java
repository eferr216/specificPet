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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpSession;
import edu.matc.controller.SearchPetsHelper;


/**
 * The servlet is responsible for performing all of the CRUD operations on our DB.
 */

@WebServlet(
        urlPatterns = {"/searchPets"}
)
public class SearchPets extends HttpServlet {
    GenericDao additionalDetailsDao = new GenericDao(AdditionalDetails.class);
    GenericDao petGenericDao = new GenericDao(Pet.class);
    GenericDao userDao = new GenericDao(User.class);
    private final Logger logger = LogManager.getLogger(this.getClass());
    SearchPetsHelper searchPetsHelper = new SearchPetsHelper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String clickedLink = req.getParameter("link");

        if (clickedLink.equals("petRequests")) {
            String userName = searchPetsHelper.getUserPetRequests(req, userDao);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewrequests.jsp?user=" + userName);
            dispatcher.forward(req, res);
        }
        else if (clickedLink.equals("viewAdditionalDetails")) {
            searchPetsHelper.getSpecificPetAdditionalDetails(req, petGenericDao);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewadditionaldetails.jsp");
            dispatcher.forward(req, res);
        }
        else if (clickedLink.equals("addNewAdditionalDetails")) {
            searchPetsHelper.getSpecificPetAdditionalDetails(req, petGenericDao);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/addadditionaldetails.jsp");
            dispatcher.forward(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (req.getParameter("searchForPetsButton") != null) {
            searchPetsHelper.searchForPets(session, userDao, req, petGenericDao);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewresults.jsp");
            dispatcher.forward(req, res);
        }
        else if (req.getParameter("insertPetRequestButton") != null) {
            User currentUser = searchPetsHelper.insertPet(req, userDao, petGenericDao);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewrequests.jsp?user=" + currentUser.getUserName());
            dispatcher.forward(req, res);
        }
        else if (req.getParameter("insertAdditionalDetailsButton") != null) {
            searchPetsHelper.insertAdditionalDetails(req, petGenericDao, additionalDetailsDao);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewadditionaldetails.jsp");
            dispatcher.forward(req, res);
        }
        else if (req.getParameter("deleteDetails") != null) {
            searchPetsHelper.deleteAdditionalDetails(req, petGenericDao, additionalDetailsDao);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewadditionaldetails.jsp");
            dispatcher.forward(req, res);
        }
        else if (req.getParameter("deleteRequest") != null) {
            String userName = searchPetsHelper.deletePet(req, userDao, petGenericDao);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewrequests.jsp?user=" + userName);
            dispatcher.forward(req, res);
        }
        else if (req.getParameter("editRequest") != null) {
            searchPetsHelper.getPetToEdit(req, petGenericDao);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/editrequest.jsp");
            dispatcher.forward(req, res);
        }
        else if (req.getParameter("confirmEditRequestButton") != null) {
            String userName = searchPetsHelper.editPet(req, userDao, petGenericDao);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewrequests.jsp?user=" + userName);
            dispatcher.forward(req, res);
        }

    }
}
