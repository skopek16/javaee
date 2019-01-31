package bskopinski.ug.javaee.servlets;

import bskopinski.ug.javaee.bean.AirConditioner;
import bskopinski.ug.javaee.repository.AirConditionerRepository;
import bskopinski.ug.javaee.repository.CartRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("AddToCart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        if (httpServletRequest.getSession().getAttribute("airConditionersCart") == null)
            httpServletRequest.getSession().setAttribute("airConditionersCart", new CartRepository());

        CartRepository cartRepository = (CartRepository) httpServletRequest.getSession().getAttribute("airConditionersCart");

        AirConditionerRepository repository = (AirConditionerRepository) getServletContext().getAttribute("airConditionersRepo");

        Integer id = Integer.valueOf(httpServletRequest.getParameter("id"));

        AirConditioner newInCart = repository.findById(id);
        if (newInCart.getQuantity() > 0) {
            if (cartRepository.getCart().contains(newInCart)) {
                AirConditioner existingConditioner = cartRepository.findById(newInCart.getId());
                if (existingConditioner.getQuantity() < newInCart.getQuantity()) {
                    existingConditioner.setQuantity(existingConditioner.getQuantity() + 1);
                }else{
                    httpServletRequest.getSession().setAttribute("message", "Not enough conditioners in stock");
                }
            } else {
                cartRepository.addAirConditioner(new AirConditioner(
                        newInCart.getId(),
                        newInCart.getName(),
                        newInCart.getDateProduction(),
                        newInCart.getPrice(),
                        newInCart.getProducer(),
                        Integer.valueOf(1)
                ));
            }
        }

        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/AllAirConditioners");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);

    }
}
