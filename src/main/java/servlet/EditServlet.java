package servlet;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        int id = Integer.parseInt(req.getParameter("id"));

        try {
            Connection con = dao.DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM students WHERE id=?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                req.setAttribute("id", rs.getInt("id"));
                req.setAttribute("name", rs.getString("name"));
                req.setAttribute("usn", rs.getString("usn"));
                req.setAttribute("fee", rs.getDouble("total_fee"));
            }

            RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");
            rd.forward(req, res);

        } catch(Exception e){
            res.getWriter().println(e.getMessage());
        }
    }
}