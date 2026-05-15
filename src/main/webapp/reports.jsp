<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reports</title>

<style>

body{
margin:0;
padding:0;
font-family:Arial;
background:linear-gradient(135deg,#102b72,#2846a3);
height:100vh;
display:flex;
justify-content:center;
align-items:center;
}

.container{
background:#f2f2f2;
width:550px;
padding:50px;
border-radius:25px;
text-align:center;
box-shadow:0 0 25px rgba(0,0,0,0.3);
}

h1{
color:#1d3fa6;
font-size:65px;
margin-bottom:40px;
}

.btn{
display:block;
width:100%;
padding:18px;
margin:18px 0;
font-size:22px;
font-weight:bold;
border:none;
border-radius:15px;
cursor:pointer;
text-decoration:none;
background:#3256d3;
color:white;
transition:0.3s;
box-sizing:border-box;
}

.btn:hover{
background:#1f3fa3;
transform:scale(1.02);
}

.home{
background:#2fad43;
}

.home:hover{
background:#238f36;
}

</style>

</head>

<body>

<div class="container">

<h1>Reports</h1>

<a href="ReportServlet?type=overdue" class="btn">
Overdue Students
</a>

<a href="daterange.jsp" class="btn">
Date Range Collection
</a>

<a href="ReportServlet?type=paid" class="btn">
Paid Students
</a>

<a href="index.jsp" class="btn home">
Home
</a>

</div>

</body>
</html>