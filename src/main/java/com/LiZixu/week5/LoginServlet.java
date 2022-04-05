package com.LiZixu.week5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();
        /*
        ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection--> in JDBCServlet "+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
         */
        con= (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get parameter from request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String r1 = null;
        try{
            Statement stmt = con.createStatement();
            String sql1 = "select  id,username,password,email,gender,birthdate from usertable where password='"+password+"' and username='"+username+"'";
            ResultSet rs1 = stmt.executeQuery(sql1);
            if(rs1.next()) {

                request.setAttribute("id", rs1.getInt("id"));
                request.setAttribute("username", rs1.getString("username"));
                request.setAttribute("password", rs1.getString("password"));
                request.setAttribute("email", rs1.getString("email"));
                request.setAttribute("gender", rs1.getString("gender"));
                request.setAttribute("birthdate", rs1.getDate("birthdate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request, response);
            }else{
                request.setAttribute("message","Username or Password Error!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            System.out.println(ex.getMessage());
        }

        //print at web
        //Existing account: { username:lizixu   password:225405 }
        /*
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if(r1 != null){
            out.println("Login Success!!!");
            out.println("<br>");
            out.println("Welcome,"+r1+".");
        }
        else
            out.println("UserName or Password Error!");
        */

    }


}
