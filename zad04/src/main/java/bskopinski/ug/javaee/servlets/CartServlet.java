
package bskopinski.ug.javaee.servlets;

import bskopinski.ug.javaee.bean.AirConditioner;
import bskopinski.ug.javaee.repository.CartRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");

        PrintWriter out = httpServletResponse.getWriter();


        if (httpServletRequest.getSession().getAttribute("airConditionersCart") == null)
            httpServletRequest.getSession().setAttribute("airConditionersCart", new CartRepository());

        CartRepository cartRepository = (CartRepository) httpServletRequest.getSession().getAttribute("airConditionersCart");

        out.println("<html><body><a href=\"/servletjspdemo/menu\" >Main page</a>" +
                "<h2>Your Cart</h2>");

        Double totalPrice = 0.00;
        for (AirConditioner airConditioner : cartRepository.getCart()) {
            out.println(
                    "</br></br>Name: " + airConditioner.getName() +
                            "<br/> Production date: " + airConditioner.getDateProduction() +
                            "<br/>Price: " + airConditioner.getPrice() +
                            "<br/>Quantity: " + airConditioner.getQuantity() +
                            "<br/>Producer: " + airConditioner.getProducer()
            );
            totalPrice += airConditioner.getPrice() * airConditioner.getQuantity();
        }
        if (totalPrice != 0) {
            out.println("<br />Total price: " + totalPrice);
            out.println(" <form action='Buy'><input type='submit' value='Buy' /></form>");
        } else {
            out.println("Your cart is empty");
        }
        out.println("</body></html>");


    }
}