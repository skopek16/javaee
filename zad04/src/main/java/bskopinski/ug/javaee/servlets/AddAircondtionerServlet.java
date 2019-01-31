package bskopinski.ug.javaee.servlets;

import bskopinski.ug.javaee.bean.AirConditioner;
import bskopinski.ug.javaee.repository.AirConditionerRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.annotation.WebServlet;

@WebServlet("/AddAirConditioner")
public class AddAircondtionerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        if (getServletContext().getAttribute("airConditionersRepo") == null)
            getServletContext().setAttribute("airConditionersRepo", new AirConditionerRepository());

        AirConditionerRepository repository = (AirConditionerRepository) getServletContext().getAttribute("airConditionersRepo");

        LocalDate prodDate = LocalDate.parse(httpServletRequest.getParameter("productionDate"));
        try {

            AirConditioner newAirConditioner = new AirConditioner(
                    repository.getId(),
                    httpServletRequest.getParameter("name"),
                    prodDate,
                    Double.valueOf(httpServletRequest.getParameter("price")),
                    httpServletRequest.getParameter("producer"),
                    Integer.valueOf(httpServletRequest.getParameter("quantity")));


            repository.addAirConditioner(newAirConditioner);
        } catch (Exception e) {
            httpServletRequest.getSession().setAttribute("message", "Wrong format of data");
            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/AddAirConditionerView");
            requestDispatcher.forward(httpServletRequest, httpServletResponse);
            return;
        }
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/AllAirConditioners");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);

    }
}