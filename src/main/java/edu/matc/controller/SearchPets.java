package edu.matc.controller;

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
        if (req.getParameter("dogCheckbox") != null) {
            logger.error("Fake error!");
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
            RequestDispatcher dispatcher = req.getRequestDispatcher("/requests.jsp");
            dispatcher.forward(req, res);
        }
    }
}
