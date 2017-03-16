package ua.projekt_vedroid.mooncalendar_server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

@WebServlet(urlPatterns = "/day")
public class DayPredictServlet extends HttpServlet {

    private GregorianCalendar calendar = new GregorianCalendar();
    //private int dayID = calendar.get(Calendar.DAY_OF_MONTH);

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int day = Integer.parseInt(request.getParameter("d"));
        //if (day == 0) day = dayID;

        StarterCLD.start();
        //while (true) {
        //    if (CurrentLunarDay.isStarted) {
        //if (day == 0) day = CurrentLunarDay.currentLunarDay;
        day = CurrentLunarDay.currentDayID + day;
        if (day < 1) day = 1;
        //        break;
        //    }
        //}

        day = LunarDay.get(day);

        System.out.println("DayPredictServlet ::: Date = " + day);

        DBConnectorDAY dbConnector = new DBConnectorDAY(day);

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String sout = day + "\n" + dbConnector.getResQ();
        out.println(sout);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doGet(request, response);
    }
}

