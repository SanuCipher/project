<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta charset="UTF-8">

<style>
body {
    margin:0;
    font-family: Arial;
    background: linear-gradient(135deg, #667eea, #764ba2);
}

.sidebar {
    width:220px;
    height:100vh;
    position:fixed;
    background:#1e1e2f;
    color:white;
}

.sidebar h2 {
    text-align:center;
    padding:20px;
}

.sidebar a {
    display:block;
    padding:15px;
    color:white;
    text-decoration:none;
}

.sidebar a:hover {
    background:#333;
}

.main {
    margin-left:220px;
    padding:20px;
    color:white;
}

.card {
    display:inline-block;
    width:200px;
    padding:20px;
    margin:15px;
    background:white;
    color:black;
    border-radius:10px;
    text-align:center;
}

.btn {
    display:block;
    margin-top:10px;
    padding:10px;
    background:#3498db;
    color:white;
    text-decoration:none;
}
</style>
</head>

<body>
<div class="main">

    <h1>💰 Smart Fee Dashboard</h1>

    <div class="card">
        <h3>Add Fee</h3>
        <a href="feepaymentadd.jsp" class="btn">Open</a>
    </div>

    <div class="card">
        <h3>View Records</h3>
        <a href="view" class="btn">Open</a>
    </div>

    <div class="card">
        <h3>Reports</h3>
        <a href="report.jsp" class="btn">Open</a>
    </div>

    <a href="view?status=Pending" style="text-decoration:none;">
<div class="card" style="background:#ff7675; color:white;">
    <h3>Pending Fees</h3>
    <p>Track unpaid students</p>
</div>
</a>

</body>
</html>