package com.LiZixu.week4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*@WebServlet(name = "JDBCServlet",urlPatterns = {"/jdbc"},
        initParams = {
        @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
        @WebInitParam(name="url",value="jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false"),
        @WebInitParam(name="username",value="lizixu01"),
        @WebInitParam(name="password",value="123456"),

        },
        loadOnStartup = 1
        )*/
@WebServlet(urlPatterns = {"/jdbc"},loadOnStartup = 1)
public class JDBCServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false";
        //String username="lizixu01";
        //String password="123456";

        //ServletConfig config=getServletConfig();

        //String driver=config.getInitParameter("driver");
        //String url=config.getInitParameter("url");
        //String username=config.getInitParameter("username");
        //String password=config.getInitParameter("password");
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
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {





        System.out.println("Connection-->"+con);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
