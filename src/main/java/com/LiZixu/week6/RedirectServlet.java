package com.LiZixu.week6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //week6.redirect
        //1.url start without"/"  -- only the last part will change
        //response.sendRedirect("index.jsp");


        //2.url start with "/"
        //response.sendRedirect("/2020211001001120LiZixu_war_exploded/index.jsp");
        //http://localhost:8080/2020211001001120LiZixu_war_exploded/


        //3.full url - absolute url
        //use when u want to access page of another website
        //response.sendRedirect("http://www.baidu.com/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
