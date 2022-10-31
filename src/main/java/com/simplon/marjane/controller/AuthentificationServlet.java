package com.simplon.marjane.controller;
import com.sun.net.httpserver.spi.HttpServerProvider;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

// create class servlet extending HttpServlet and override doGet and doPost methods
public class AuthentificationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get the request dispatcher
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
        // forward the request to the view
        dispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get request parameters for userID and password
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        if (user.equals("admin") && pwd.equals("admin123")) {
            HttpSession session = req.getSession();
            session.setAttribute("user", "admin");
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
            Cookie userName = new Cookie("user", user);
            resp.addCookie(userName);
            resp.sendRedirect("loginSuccess.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            PrintWriter out= resp.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(req, resp);
        }
    }
}
