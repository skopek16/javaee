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
import java.util.List;

@WebServlet("/cameras")
public class AllCameraServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        CameraService ns = (CameraService)getServletContext().getAttribute("app_news");

        List<Camera> allCameras = ns.getAllCamera();

        out.append("<html><body><h2>Wszystkie kamery:</h2>");


        for (Camera camera : allCameras) {
                out.append("<form action='buyCamera'>");
                out.append("<input type='hidden' name='name' value='" + camera.getName() + "'/>");
                out.append("<p>Nazwa: " + camera.getName() + "</p>");
                out.append("<p>Data: " + camera.getDate() + "</p>");

                out.append("<p>kolor: " + camera.getColor() + "</p>");
                out.append("<p>dodatki: " + camera.getExtras() + "</p>");
                out.append("<input type='submit' value='Kup' />");
                out.append("</form>");
        }

        out.append("</body></html>");
        out.close();

    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("app_news", new CameraService());
    }
}