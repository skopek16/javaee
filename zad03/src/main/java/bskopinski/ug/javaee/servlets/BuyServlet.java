package bskopinski.ug.javaee.servlets;

import bskopinski.ug.javaee.bean.AirConditioner;
import bskopinski.ug.javaee.repository.AirConditionerRepository;
import bskopinski.ug.javaee.repository.CartRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("Buy")
public class BuyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse response) throws ServletException, IOException {

        AirConditionerRepository repository = (AirConditionerRepository) getServletContext().getAttribute("airConditionersRepo");

        CartRepository cartRepository = (CartRepository) httpServletRequest.getSession().getAttribute("airConditionersCart");

        for (AirConditioner airConditioner : cartRepository.getCart()) {
            AirConditioner existing = repository.findById(airConditioner.getId());
            existing.setQuantity(existing.getQuantity() - airConditioner.getQuantity());
        }

        cartRepository.getCart().clear();

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body><h2>Buy</h2>" +
                        "Thank you for your purchase <br/>" +
                "<a href='/servletjspdemo/menu'>Go back to menu</a></body></html>");


    }
}
