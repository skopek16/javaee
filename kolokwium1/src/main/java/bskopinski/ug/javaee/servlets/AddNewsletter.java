package bskopinski.ug.javaee.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/addNewsletter")
public class AddNewsletter {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StorageService ssRodo = (StorageService) getServletContext().getAttribute("rodo_service");

        if(!ssRodo.getRodoStatus()) {
            response.sendRedirect("/zad04/rodo-form.jsp");
        }

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");

        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

        String producer = request.getParameter("producer");
        Date productionDate = null;
        try {
            productionDate = formatter.parse(request.getParameter("productionDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double combustion = Double.parseDouble(request.getParameter("combustion"));
        boolean vipStatus = Boolean.parseBoolean(request.getParameter("vipStatus"));
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        int id = ss.getId();

        Plane newPlane = new Plane(id, producer, productionDate, combustion, vipStatus, price, quantity);

        ss.add(newPlane);

        List<Plane> allPlanes = ss.getAllPlanes();

        out.append("<html><body><h2>All Planes:</h2>");

        for (Plane plane: allPlanes) {
            out.append("<p>id: " + plane.getId() + "</p>");
            out.append("<p>Producer: " + plane.getProducer() + "</p>");
            out.append("<p>Production date: " + plane.getProductionDate() + "</p>");
            out.append("<p>Combustion: " + plane.getCombustion() + "</p>");
            out.append("<p>Price: " + plane.getPrice() + "</p>");
            out.append("<p>Quantity: " + plane.getQuantity() + "</p>");
            out.append("<p>Vip Status: " + plane.isVipStatus() + "</p><br>");
        }

        out.append("<a href='add-plane'>Add another plane</a><br>");
        out.append("<a href='all-planes'>Go to store</a>");
        out.append("</body></html>");
        out.close();
    }

}
