package servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import dao.FeePaymentDAO;
import model.FeePayment;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        try {
            FeePaymentDAO dao = new FeePaymentDAO();
            ArrayList<FeePayment> list = dao.getAll();

            // 🔍 SEARCH
            String search = req.getParameter("search");
            if(search != null && !search.isEmpty()){
                ArrayList<FeePayment> temp = new ArrayList<>();

                for(FeePayment f : list){
                    if(f.getName().toLowerCase().contains(search.toLowerCase())){
                        temp.add(f);
                    }
                }
                list = temp;
            }

            // 🔥 PENDING FILTER
            String status = req.getParameter("status");
            if(status != null && status.equals("Pending")){
                list.removeIf(f -> (f.getTotalFee() - f.getPaidAmount()) <= 0);
            }

            req.setAttribute("data", list);

            RequestDispatcher rd = req.getRequestDispatcher("feepaymentdisplay.jsp");
            rd.forward(req, res);

        } catch(Exception e){
            res.getWriter().println(e.getMessage());
        }
    }
}