package com.example.hibernate_tomcathw;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/check")
public class Check extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/check.jsp";
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        req.setAttribute("title1", "Добавлено");
        req.setAttribute("username", username);
        req.setAttribute("age", age);

        UserService.add(new User(username, age));

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
