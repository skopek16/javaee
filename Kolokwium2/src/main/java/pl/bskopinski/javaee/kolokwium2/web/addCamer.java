package pl.bskopinski.javaee.kolokwium2.web;

import pl.bskopinski.javaee.kolokwium2.domain.Camera;
import pl.bskopinski.javaee.kolokwium2.service.CameraService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@WebServlet("/add-camera")
public class addCamer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //session context
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();

        CameraService ns = (CameraService)getServletContext().getAttribute("app_news");
        List<Camera> allCameras = ns.getAllCamera();


        Camera sCamera = null;
        String name = request.getParameter("name");
        String date = request.getParameter("date");

        String frequency = request.getParameter("color");
        String extrasSelected = "";
        int cheack=0;



        for (String subject : request.getParameterValues("extras")) {
            extrasSelected += subject + " ";
        }

            sCamera = new Camera(name, date,  frequency, extrasSelected);
            ns.addCamera(sCamera);
       
        response.sendRedirect("cameras");
    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("app_news", new CameraService());
    }
}