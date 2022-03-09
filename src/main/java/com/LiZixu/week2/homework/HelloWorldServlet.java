package com.LiZixu.week2.homework;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloWorldServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        //
        PrintWriter writer = response.getWriter();
        writer.println("Name:LiZixu");
        writer.println("Id:2020211001001120");
        writer.println("Date and Time:Wed Mar 9 15:18:10 2022");
        //next need to tell about this servlet to tomcat - how? - xml
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
