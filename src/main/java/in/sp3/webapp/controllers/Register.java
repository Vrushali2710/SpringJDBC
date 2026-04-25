package in.sp3.webapp.controllers;

import in.sp3.webapp.dbconn.DBConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String city = req.getParameter("city");
        try {
            Connection con = DBConnection.getConnection();
            String insert_query = "INSERT INTO Users VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(insert_query);
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,password);
            ps.setString(4,city);
            int count = ps.executeUpdate();
            if(count > 0) {
                System.out.println("<h3 style='color:green'>Registered Successfully</h3>");
                RequestDispatcher rd = req.getRequestDispatcher("/login.html");
                rd.include(req,resp);

            } else {
                System.out.println("<h3 style='color:red'>User not registered due to some error</h3>");
                RequestDispatcher rd = req.getRequestDispatcher("/register.html");
                rd.include(req,resp);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
