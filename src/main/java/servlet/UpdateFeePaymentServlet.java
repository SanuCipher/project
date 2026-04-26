package servlet;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/update")
public class UpdateFeePaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        try {
            Connection con = dao.DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "UPDATE students SET name=?, usn=?, total_fee=? WHERE id=?");

            ps.setString(1, req.getParameter("name"));
            ps.setString(2, req.getParameter("usn"));
            ps.setDouble(3, Double.parseDouble(req.getParameter("fee")));
            ps.setInt(4, Integer.parseInt(req.getParameter("id")));

            ps.executeUpdate();

            res.sendRedirect("view");

        } catch(Exception e){
            res.getWriter().println(e.getMessage());
        }
    }
}