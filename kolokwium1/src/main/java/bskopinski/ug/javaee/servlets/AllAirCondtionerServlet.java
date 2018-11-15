
package bskopinski.ug.javaee.servlets;

import bskopinski.ug.javaee.bean.AirConditioner;
import bskopinski.ug.javaee.repository.AirConditionerRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AllAirConditioners")
public class AllAirCondtionerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");

        PrintWriter out = httpServletResponse.getWriter();


        if (getServletContext().getAttribute("airConditionersRepo") == null)
            getServletContext().setAttribute("airConditionersRepo", new AirConditionerRepository());

        AirConditionerRepository repository = (AirConditionerRepository) getServletContext().getAttribute("airConditionersRepo");
        out.println("<html><body><a href=\"/servletjspdemo/menu\" >Main page</a>" +
                "<h2>All Air Conditioners</h2>");
        if (httpServletRequest.getSession().getAttribute("message") != null && !httpServletRequest.getSession().getAttribute("message").equals("")) {
            out.println(httpServletRequest.getSession().getAttribute("message"));
            httpServletRequest.getSession().setAttribute("message", "");
        }
        for (AirConditioner airConditioner : repository.getAirConditioners()) {
            if (airConditioner.getQuantity() != 0) {
                out.println(
                        "</br></br>Name: " + airConditioner.getName() +
                                "<br/> Production date: " + airConditioner.getDateProduction() +
                                "<br/>Price: " + airConditioner.getPrice() +
                                "<br/>Quantity: " + airConditioner.getQuantity() +
                                "<br/>Producer: " + airConditioner.getProducer() +
                                "<form action=\"AddToCart\">" +
                                "<input type='hidden' name='id' value='" +
                                airConditioner.getId() + "'/>" +
                                "<input type='submit' value=' Add to Cart' /></form>"
                );
            }
        }
        out.println("</body></html>");


    }
}