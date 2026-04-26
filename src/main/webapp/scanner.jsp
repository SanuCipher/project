<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
</head>

<body style="text-align:center;">

<h2>📱 Scan & Pay</h2>

<img src="https://api.qrserver.com/v1/create-qr-code/?size=200x200&data=FeePayment">

<br><br>

<form action="pay" method="post">
<input type="hidden" name="student_id" value="<%= request.getParameter("student_id") %>">
<input type="hidden" name="amount" value="<%= request.getParameter("amount") %>">

<button onclick="return confirm('Are you sure you want to pay?')">
Pay Now
</button>
</form>

</body>
</html>