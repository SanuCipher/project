package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pay")
public class PayServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        int studentId = Integer.parseInt(req.getParameter("student_id"));
        double amount = Double.parseDouble(req.getParameter("amount"));

        try {
            Connection con = dao.DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO payments(student_id, paid_amount, paid_date) VALUES (?, ?, CURDATE())");

            ps.setInt(1, studentId);
            ps.setDouble(2, amount);

            ps.executeUpdate();

            res.sendRedirect("receipt?sid=" + studentId);

        } catch(Exception e){
            res.getWriter().println(e.getMessage());
        }
    }
}