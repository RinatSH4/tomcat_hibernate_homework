package com.example.hibernate_tomcathw;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class Edit extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "/edit.jsp";

        int id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        req.setAttribute("title1", "Изменено");
        req.setAttribute("username", username);
        req.setAttribute("age", age);

        UserService.edit(new User(username, age), id);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
