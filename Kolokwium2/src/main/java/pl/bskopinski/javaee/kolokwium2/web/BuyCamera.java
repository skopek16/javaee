package pl.bskopinski.javaee.kolokwium2.web;

import pl.bskopinski.javaee.kolokwium2.domain.Camera;
import pl.bskopinski.javaee.kolokwium2.service.CameraService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet("/buyCamera")
public class BuyCamera extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        CameraService ns = (CameraService)getServletContext().getAttribute("app_news");

        List<Camera> allCameras = ns.getAllCamera();

        String name = request.getParameter("name");

        for (Iterator<Camera> iter = allCameras.listIterator(); iter.hasNext(); ) {
            Camera a = iter.next();
            if (a.getName().equals(name)) {

                out.append("<p>Kupiles:</p>");
                out.append("<p>Nazwa: " + a.getName() + "</p>");
                    out.append("<p>Data: " + a.getDate() + "</p>");

                out.append("<p>kolor: " + a.getColor() + "</p>");
                out.append("<p>dodatki: " + a.getExtras() + "</p>");
                iter.remove();


            }
        }

        out.append("<a href='cameras'>Przenies do wszystkich Kamer</a>");
        out.append("</body></html>");
        out.close();

    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("app_news", new CameraService());
    }
}