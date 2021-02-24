package ua.vedroid.mooncalendar.server.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.vedroid.mooncalendar.server.service.PersonalPredictionService;

@WebServlet(urlPatterns = "/pay")
public class PersonalPredictionServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int day = Integer.parseInt(req.getParameter("d"));
        int month = Integer.parseInt(req.getParameter("m"));
        int year = Integer.parseInt(req.getParameter("y"));

        PersonalPredictionService service = new PersonalPredictionService();
        String prediction = service.getPrediction(day, month, year)
                + service.getZodiacInfo(day, month, year);

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println(prediction);
    }
}
