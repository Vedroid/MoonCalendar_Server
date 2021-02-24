package ua.vedroid.mooncalendar.server.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.vedroid.mooncalendar.server.service.LunarDayService;
import ua.vedroid.mooncalendar.server.service.PredictionService;

@WebServlet(urlPatterns = "/day")
public class DayPredictionServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LunarDayService lunarDayService = new LunarDayService();
        PredictionService predictionService = new PredictionService();

        int currentLunarDay = lunarDayService.getCurrentLunarDay();
        int day = lunarDayService
                .getLunarDay(currentLunarDay + Integer.parseInt(req.getParameter("d")));

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println(day + "\n" + predictionService.getPrediction(day));
    }
}
