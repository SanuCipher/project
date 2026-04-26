package dao;

import java.sql.*;
import java.util.ArrayList;
import model.FeePayment;

public class FeePaymentDAO {

    public ArrayList<FeePayment> getAll() throws Exception {

        ArrayList<FeePayment> list = new ArrayList<>();

        Connection con = DBConnection.getConnection();

        String sql =
            "SELECT s.id, s.name, s.usn, s.total_fee, " +
            "IFNULL(SUM(p.paid_amount),0) AS paid_amount " +
            "FROM students s " +
            "LEFT JOIN payments p ON s.id = p.student_id " +
            "GROUP BY s.id, s.name, s.usn, s.total_fee";

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            FeePayment f = new FeePayment();

            f.setId(rs.getInt("id"));
            f.setName(rs.getString("name"));
            f.setUsn(rs.getString("usn"));
            f.setTotalFee(rs.getDouble("total_fee"));
            f.setPaidAmount(rs.getDouble("paid_amount"));

            list.add(f);
        }

        con.close();
        return list;
    }
}