package bskopinski.ug.javaee.servlets;


import bskopinski.ug.javaee.bean.NewsLetter;
import bskopinski.ug.javaee.repository.AirConditionerRepository;
import bskopinski.ug.javaee.repository.NewsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/addNewsletter")
public class AddNewsletter extends HttpServlet {

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {

        if (getServletContext().getAttribute("newsRepo") == null)
            getServletContext().setAttribute("newsRepo", new NewsRepository());

        NewsRepository repository = (NewsRepository) getServletContext().getAttribute("newsRepo");

        LocalDate dataOd = LocalDate.parse(httpServletRequest.getParameter("dataOd"));

        LocalDate dataDo = LocalDate.parse(httpServletRequest.getParameter("dataDo"));
        NewsLetter newNewsLetter = new NewsLetter(

                httpServletRequest.getParameter("name"),

                dataOd,
                dataDo,

                httpServletRequest.getParameter("czestotliwosc"),

                httpServletRequest.getParameter("tematyka")
                );


    }

}
