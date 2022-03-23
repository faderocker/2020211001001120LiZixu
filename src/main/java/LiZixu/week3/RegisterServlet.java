package LiZixu.week3;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get parameter from request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("birthdate");
        int ID = 1;


        //input the info into usertable
        try {
            Statement stmt = con.createStatement();
            String sql = "insert into usertable values('"+ID+"','"+username+"','"+password+"','"+email+"','"+gender+"','"+birthdate+"')";
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            System.out.println(ex.getMessage());
        }



        //selcet info from usertable
        int r1 = 0;
        String r2 = null,r3=null,r4=null,r5=null,r6=null;
        try{
            Statement stmt = con.createStatement();
            String sql1 = "select id from usertable ";
            ResultSet rs1 = stmt.executeQuery(sql1);
            while(rs1.next()){ r1=rs1.getInt("id"); }
            String sql2 = "select username from usertable ";
            ResultSet rs2 = stmt.executeQuery(sql2);
            while(rs2.next()){ r2=rs2.getString("username"); }
            String sql3 = "select password from usertable ";
            ResultSet rs3 = stmt.executeQuery(sql3);
            while(rs3.next()){r3=rs3.getString("password");}
            String sql4 = "select email from usertable ";
            ResultSet rs4 = stmt.executeQuery(sql4);
            while(rs4.next()){r4=rs4.getString("email");}
            String sql5 = "select gender from usertable ";
            ResultSet rs5 = stmt.executeQuery(sql5);
            while(rs5.next()){r5=rs5.getString("gender");}
            String sql6 = "select birthdate from usertable ";
            ResultSet rs6 = stmt.executeQuery(sql6);
            while(rs6.next()){r6=rs6.getString("birthdate");}
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            System.out.println(ex.getMessage());
        }

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        System.out.println(r5);
        System.out.println(r6);


        //print at web
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>UsingServlet</title></head>");
        out.println("<body>");
        out.println("<table border=\"1px\" bordercolor=\"#000000\">");

        out.println("<tr> <td>ID</td> <td>UserName</td> <td>Password</td> <td>Email</td> <td>Gender</td> <td>Birthdate</td> </tr>");
        out.println("<tr> <td>"+r1+"</td><td>"+r2+"</td><td>"+r3+"</td><td>"+r4+"</td><td>"+r5+"</td><td>"+r6+"</td></tr>");
        out.println("</table>");
        out.println("</body></html>");


    }


}