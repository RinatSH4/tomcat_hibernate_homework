package com.example.hibernate_tomcathw;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/find")
public class Find extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/find.jsp";
        String username = req.getParameter("username");

        try {
            User user = UserService.find(username);
            req.setAttribute("title1", "Найдено: ");
            req.setAttribute("username", user.getUsername());
            req.setAttribute("age", user.getAge());
        } catch (Exception e) {
            url = "/catch.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
