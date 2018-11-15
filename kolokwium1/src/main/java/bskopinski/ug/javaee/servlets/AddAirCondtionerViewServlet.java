package bskopinski.ug.javaee.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddAirCondtionerView")
public class AddAirCondtionerViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (httpServletRequest.getSession().getAttribute("message") != null && !httpServletRequest.getSession().getAttribute("message").equals("")) {
            out.println(httpServletRequest.getSession().getAttribute("message"));
            httpServletRequest.getSession().setAttribute("message", "");
        }

        out.println("<h2>Add air condtioner:</h2>" +
                "<form action='AddAirConditioner'>" +
                "Name: <input type='text' name='name' /> <br/>" +
                "Production date: <input type='text' name='productionDate' /> <br/>" +
                "Price: <input type='text' name='price' /> <br/>" +
                "Quantity: <input type='number' name='quantity' /> <br/>" +
                "Producer: <input type='text' name='producer' /> <br/>" +
                "<input type='submit' value=' Add ' />" +
                "</form>" +
                "</body></html>");

    }

}

