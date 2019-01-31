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

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String rodo_status =(String)session.getAttribute("rodo_status");



//        if(session.getAttribute("rodo_status").equals("on") ) {
//            response.sendRedirect("/servletjspdemo/menu");
//        } else {
//            response.sendRedirect("/servletjspdemo/Rodo.jsp");
//        }
        response.setContentType("text/html");
        if(rodo_status== null){
            response.sendRedirect("/servletjspdemo/Rodo.jsp");
        }

        PrintWriter out = response.getWriter();

        out.println("<html><body>Witaj "+session.getAttribute("user_name") +"</br><ul><li><a href='/servletjspdemo/AddAirCondtionerView'>Add Air Condtioner</a></li>" +
                "<li><a href='/servletjspdemo/AllAirConditioners'> Show All Condtioners</a></li>"+
                "<li><a href='/servletjspdemo/Cart'> Show Cart</a></li></ul></body></html>");
    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("airConditionersRepo", new AirConditionerRepository());
    }

}