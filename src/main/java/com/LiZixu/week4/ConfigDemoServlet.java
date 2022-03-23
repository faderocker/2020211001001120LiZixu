package com.LiZixu.week4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/config")
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context=getServletContext();
        String name=context.getInitParameter("name");
        String studentId=context.getInitParameter("studentId");
        PrintWriter writer = response.getWriter();
        writer.println("name:"+name);
        writer.println("studentId:"+studentId);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
