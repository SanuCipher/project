package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/download")
public class ReportServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/csv");
        res.setHeader("Content-Disposition", "attachment; filename=report.csv");

        PrintWriter out = res.getWriter();
        out.println("Name,Amount,DueDate,Status");

        try {
            Connection con = dao.DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM FeePayments");

            while (rs.next()) {
                out.println(
                    rs.getString("name") + "," +
                    rs.getDouble("amount") + "," +
                    rs.getDate("due_date") + "," +
                    rs.getString("status")
                );
            }

            con.close();

        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }
}