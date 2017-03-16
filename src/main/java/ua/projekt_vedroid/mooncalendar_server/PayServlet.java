package ua.projekt_vedroid.mooncalendar_server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PayServlet", urlPatterns = "/pay")
public class PayServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int day = Integer.parseInt(request.getParameter("d"));
        int month = Integer.parseInt(request.getParameter("m"));
        int year = Integer.parseInt(request.getParameter("y"));

        System.out.println("PayServlet ::: Date = " + day + "." + month + "." + year);

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(Calculation.setData(day, month, year));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doGet(request, response);
    }
}
