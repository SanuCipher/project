package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/receipt")
public class ReciptServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html; charset=UTF-8"); // ✅ FIX ENCODING

        PrintWriter out = res.getWriter();

        int sid = Integer.parseInt(req.getParameter("sid"));

        try {
            Connection con = dao.DBConnection.getConnection();

            ResultSet rs = con.createStatement().executeQuery(
                "SELECT s.name, s.usn, p.paid_amount, p.paid_date " +
                "FROM students s JOIN payments p ON s.id=p.student_id " +
                "WHERE s.id=" + sid + " ORDER BY p.id DESC LIMIT 1"
            );

            if (rs.next()) {

                out.println("<html><head><title>Receipt</title></head><body style='font-family:Arial;'>");

                out.println("<div style='width:350px; margin:50px auto; padding:20px; border:1px solid #ccc; border-radius:10px; box-shadow:0 0 10px gray;'>");

                out.println("<h2 style='color:green; text-align:center;'>Payment Successful ✅</h2>");

                out.println("<hr>");

                out.println("<p><b>Name:</b> " + rs.getString("name") + "</p>");
                out.println("<p><b>USN:</b> " + rs.getString("usn") + "</p>");
                out.println("<p><b>Amount Paid:</b> &#8377;" + rs.getDouble("paid_amount") + "</p>");
                out.println("<p><b>Date:</b> " + rs.getDate("paid_date") + "</p>");

                out.println("<hr>");

                out.println("<p style='text-align:center;'>Thank you for your payment!</p>");

                out.println("<div style='text-align:center;'>");
                out.println("<button onclick='window.print()'>🖨 Print Receipt</button>");
                out.println("</div>");

                out.println("</div>");

                out.println("</body></html>");
            }

            con.close();

        } catch (Exception e) {
            out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
        }
    }
}