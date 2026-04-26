package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/delete")
public class DeleteFeePaymentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        try {
            Connection con = dao.DBConnection.getConnection();

            // 🔥 delete payments first
            PreparedStatement ps1 = con.prepareStatement(
                "DELETE FROM payments WHERE student_id=?");
            ps1.setInt(1, id);
            ps1.executeUpdate();

            // 🔥 delete student also (important)
            PreparedStatement ps2 = con.prepareStatement(
                "DELETE FROM students WHERE id=?");
            ps2.setInt(1, id);
            ps2.executeUpdate();

            res.sendRedirect("view");

        } catch(Exception e){
            res.getWriter().println("<h3 style='color:red'>" + e.getMessage() + "</h3>");
        }
    }
}