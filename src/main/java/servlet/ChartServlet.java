package servlet;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/chartdata")
public class ChartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("application/json");
        PrintWriter out = res.getWriter();

        StringBuilder names = new StringBuilder("[");
        StringBuilder amounts = new StringBuilder("[");

        try {
            Connection con = dao.DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM FeePayments");

            while (rs.next()) {
                names.append("\"").append(rs.getString("name")).append("\",");
                amounts.append(rs.getDouble("amount")).append(",");
            }

            // remove last comma
            if (names.length() > 1) names.deleteCharAt(names.length() - 1);
            if (amounts.length() > 1) amounts.deleteCharAt(amounts.length() - 1);

            names.append("]");
            amounts.append("]");

            out.print("{\"names\":" + names + ",\"amounts\":" + amounts + "}");

            con.close();

        } catch (Exception e) {
            out.print("{\"names\":[],\"amounts\":[]}");
        }
    }
}