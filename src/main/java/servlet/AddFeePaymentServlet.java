package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import dao.*;
import model.*;

@WebServlet("/add")
public class AddFeePaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
    	String name = req.getParameter("name");
    	double total = Double.parseDouble(req.getParameter("total"));
    	double paid = Double.parseDouble(req.getParameter("paid"));
    	String due = req.getParameter("dueDate");

    	java.sql.Date dueDate = java.sql.Date.valueOf(due);

    	double remaining = total - paid;

    	String status;

    	if(remaining <= 0) {
    	    status = "Paid";
    	} else if(dueDate.before(new java.util.Date())) {
    	    status = "Overdue";
    	} else {
    	    status = "Pending";
    	}
    }
}