package ua.vedroid.mooncalendar.server.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.vedroid.mooncalendar.server.service.LunarDayService;

@WebServlet(urlPatterns = "/current")
public class CurrentLunarDayServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println(new LunarDayService().getCurrentLunarDay());
    }
}
