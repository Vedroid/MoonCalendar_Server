package ua.projekt_vedroid.mooncalendar_server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("TestServlet ::: ");

        StarterCLD.start();

        //int day = Integer.parseInt(request.getParameter("d"));

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        while (true) {
            if (CurrentLunarDay.isStarted) {
                System.out.println("TestServlet ::: Out Print.");
                out.println(CurrentLunarDay.currentLunarDay);
                break;
            }
        }
    }

/*
    private void startThread() {
        if (ldg != null) {
            if (!ldg.isAlive()) {
                System.out.println("TestServlet ::: Thread restarted.");
                ldg = new CurrentLunarDay();
                ldg.setDaemon(true);
                ldg.start();
            }
        } else {
            System.out.println("TestServlet ::: Thread started.");
            ldg = new CurrentLunarDay();
            ldg.setDaemon(true);
            ldg.start();
        }
    }
*/

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doGet(request, response);
    }
}
