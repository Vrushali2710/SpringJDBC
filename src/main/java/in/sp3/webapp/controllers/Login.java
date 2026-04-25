package in.sp3.webapp.controllers;

import in.sp3.webapp.dbconn.DBConnection;
import in.sp3.webapp.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.lang.System.out;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String email = req.getParameter("email");
       String password = req.getParameter("password");
       try {
           Connection con = DBConnection.getConnection();
           String select_query = "SELECT * FROM users WHERE email=? AND password=?";

           PreparedStatement ps = con.prepareStatement(select_query);
           ps.setString(1,email);
           ps.setString(2,password);
           ResultSet rs =ps.executeQuery();
           if(rs.next()) {
               User user = new User();
               user.setName(rs.getString("name"));
               user.setEmail(rs.getString("email"));
               user.setCity(rs.getString("city"));
               HttpSession session = req.getSession();
               session.setAttribute("session_user",user);
               RequestDispatcher rd= req.getRequestDispatcher("/profile.jsp");
               rd.forward(req,resp);

           } else {
               out.println("Email id and password didn't match");
               RequestDispatcher rd =req.getRequestDispatcher("/login.html");
               rd.include(req,resp);


           }
       }
        catch (Exception e) {
           e.printStackTrace();
       }
    }
}
