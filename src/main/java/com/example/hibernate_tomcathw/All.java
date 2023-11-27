package com.example.hibernate_tomcathw;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/all")
public class All extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/all.jsp";
        List<User> users = UserService.getAll();
            req.setAttribute("count", users.size());
        req.getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
