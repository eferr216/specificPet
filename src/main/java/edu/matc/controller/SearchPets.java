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
import javax.servlet.http.HttpSession;

/**
 * The servlet is responsible for performing all of the CRUD operations on our DB.
 */

@WebServlet(
        urlPatterns = {"/searchPets"}
)
public class SearchPets extends HttpServlet {
    //GenericDao additionalDetailsDao = new GenericDao(AdditionalDetails.class);
    //GenericDao petGenericDao = new GenericDao(Pet.class);
    //GenericDao userDao = new GenericDao(User.class);
    private final Logger logger = LogManager.getLogger(this.getClass());
    SearchPetsHelper searchPetsHelper = new SearchPetsHelper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String clickedLink = req.getParameter("link");

        if (clickedLink.equals("petRequests")) {
            String userName = searchPetsHelper.getUserPetRequests(req);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewrequests.jsp?user=" + userName);
            dispatcher.forward(req, res);
        }
        else if (clickedLink.equals("viewAdditionalDetails")) {
            searchPetsHelper.getSpecificPetAdditionalDetails(req);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewadditionaldetails.jsp");
            dispatcher.forward(req, res);
        }
        else if (clickedLink.equals("addNewAdditionalDetails")) {
            searchPetsHelper.getSpecificPetAdditionalDetails(req);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/addadditionaldetails.jsp");
            dispatcher.forward(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (req.getParameter("searchForPetsButton") != null) {
            searchPetsHelper.searchForPets(session, req);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewresults.jsp");
            dispatcher.forward(req, res);
        }
        else if (req.getParameter("insertPetRequestButton") != null) {
            User currentUser = searchPetsHelper.insertPet(req);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewrequests.jsp?user=" + currentUser.getUserName());
            dispatcher.forward(req, res);
        }
        else if (req.getParameter("insertAdditionalDetailsButton") != null) {
            searchPetsHelper.insertAdditionalDetails(req);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewadditionaldetails.jsp");
            dispatcher.forward(req, res);
        }
        else if (req.getParameter("deleteDetails") != null) {
            searchPetsHelper.deleteAdditionalDetails(req);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewadditionaldetails.jsp");
            dispatcher.forward(req, res);
        }
        else if (req.getParameter("deleteRequest") != null) {
            String userName = searchPetsHelper.deletePet(req);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewrequests.jsp?user=" + userName);
            dispatcher.forward(req, res);
        }
        else if (req.getParameter("editRequest") != null) {
            searchPetsHelper.getPetToEdit(req);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/editrequest.jsp");
            dispatcher.forward(req, res);
        }
        else if (req.getParameter("confirmEditRequestButton") != null) {
            String userName = searchPetsHelper.editPet(req);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewrequests.jsp?user=" + userName);
            dispatcher.forward(req, res);
        }

    }
}
