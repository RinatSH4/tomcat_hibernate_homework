package com.example.hibernate_tomcathw;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class Delete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/delete.jsp";
        String username = req.getParameter("username");
        req.setAttribute("username", username);
        UserService.delete(username);

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
