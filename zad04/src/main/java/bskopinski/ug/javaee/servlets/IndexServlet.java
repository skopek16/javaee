package bskopinski.ug.javaee.servlets;


import bskopinski.ug.javaee.repository.AirConditionerRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/menu")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body><ul><li><a href='/servletjspdemo/AddAirCondtionerView'>Add Air Condtioner</a></li>" +
                "<li><a href='/servletjspdemo/AllAirConditioners'> Show All Condtioners</a></li>"+
                "<li><a href='/servletjspdemo/Cart'> Show Cart</a></li></ul></body></html>");
    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("airConditionersRepo", new AirConditionerRepository());
    }

}