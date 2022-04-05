package com.LiZixu.week6;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = request.getParameter("txt");
        String search = request.getParameter("search");
        System.out.println("--------YOUR--SEARCH------------------------------");
        System.out.println(txt);
        if(txt == ""){
            response.sendRedirect("http://localhost:8080/2020211001001120LiZixu_war_exploded/index.jsp");
        }else{
            if(search=="baidu") response.sendRedirect("https://www.baidu.com/s?wd="+txt);
           // if(search=="bing"){response.sendRedirect("https://cn.bing.com/search?q="+txt);}
            //if(search=="google"){response.sendRedirect("https://www.google.com/search?q="+txt);}
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
