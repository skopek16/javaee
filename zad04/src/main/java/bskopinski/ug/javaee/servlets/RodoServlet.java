package bskopinski.ug.javaee.servlets;


import bskopinski.ug.javaee.repository.AirConditionerRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/rodo-check")
public class RodoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String rodo = request.getParameter("rodo");
        response.setContentType("text/html");

        session.setAttribute("user_name",request.getParameter("firstName"));

        session.setAttribute("rodo_status",rodo);

        if(rodo.equals("on")) {
            response.sendRedirect("/servletjspdemo/menu");
        } else {
            response.sendRedirect("/servletjspdemo/Rodo.jsp");
        }




    }
}
