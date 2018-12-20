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

        if (session.getAttribute("sess_news") == null) {
            sCamera = new Camera(name, date,  frequency, extrasSelected);
            ns.addCamera(sCamera);
        } else {
//                sCamera = (Camera) session.getAttribute("sess_news");
//                ns.removeNewsletter(sCamera);


            sCamera = new Camera(name, date, frequency, extrasSelected);

                for (Iterator<Camera> iter = allCameras.listIterator(); iter.hasNext(); ) {
                    Camera a = iter.next();
                    if (a.getName().equals(name)) {

                        ((ListIterator<Camera>) iter).set(sCamera);
                        cheack=1;
                    }

                }
                if(cheack==0){
                    sCamera = new Camera(name, date,frequency, extrasSelected);
                    ns.addCamera(sCamera);
                }

            }
//


        session.setAttribute("sess_news", sCamera);

        response.sendRedirect("cameras");
    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("app_news", new CameraService());
    }
}