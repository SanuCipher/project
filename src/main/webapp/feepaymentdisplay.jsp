<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*,model.FeePayment" %>

<html>
<head>
<meta charset="UTF-8">

<style>
body { font-family: Arial; background:#f4f6f9; }

table {
    border-collapse: collapse;
    width: 80%;
    margin: auto;
}

th, td {
    padding: 10px;
    border: 1px solid gray;
    text-align: center;
}

th { background: #3498db; color: white; }

.search-box {
    text-align: center;
    margin: 20px;
}
</style>

</head>

<body>

<h2 align="center">Student Fee Records</h2>

<div class="search-box">
<form action="view" method="get">
<input type="text" name="search" placeholder="Search student">
<button>Search</button>
</form>
</div>

<table>
<tr>
<th>Name</th>
<th>USN</th>
<th>Total Fee</th>
<th>Paid</th>
<th>Remaining</th>
<th>Status</th>
<th>Action</th>
</tr>

<%
ArrayList<FeePayment> list = (ArrayList<FeePayment>)request.getAttribute("data");

if(list != null && list.size() > 0){

    for(FeePayment f : list){

        double remaining = f.getTotalFee() - f.getPaidAmount();
        String status = remaining <= 0 ? "Paid" : "Pending";
%>

<tr>
<td><%= f.getName() %></td>
<td><%= f.getUsn() %></td>
<td><%= f.getTotalFee() %></td>
<td><%= f.getPaidAmount() %></td>
<td><%= remaining %></td>
<td><%= status %></td>

<td>
<a href="delete?id=<%=f.getId()%>" 
onclick="return confirm('Are you sure to delete?')">
Delete
</a>
<a href="edit?id=<%=f.getId()%>">Edit</a>
</td>
</tr>

<%
    }

} else {
%>

<tr>
<td colspan="7">No records found</td>
</tr>

<%
}
%>

</table>

</body>
</html>