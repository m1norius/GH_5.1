package com.minorius.servlets;

import com.minorius.data.SessionData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(urlPatterns = {"/servlet"})
public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(600);
        Map<LocalDateTime, SessionData> sessionDataMap = (Map<LocalDateTime, SessionData>) session.getAttribute("sessionDataMap");
        if(sessionDataMap == null){
            sessionDataMap = new TreeMap<>(REV_DATE_COMP);
            session.setAttribute("sessionDataMap", sessionDataMap);
        }

        LocalDateTime time = LocalDateTime.now();

        String name = request.getParameter("name");
        String message = request.getParameter("message");
        String rating = request.getParameter("rating");

        SessionData data = new SessionData(name, message, rating);
        sessionDataMap.put(time, data);

        session.setAttribute("enumBook", sessionDataMap);

        request.getRequestDispatcher("/index.jsp").forward(request, response);


    }

    private static final Comparator<LocalDateTime> REV_DATE_COMP = Comparator.reverseOrder();
}
