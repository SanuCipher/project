<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta charset="UTF-8">

<script>
function showUSN(){
    let select = document.getElementById("student");
    let usn = select.options[select.selectedIndex].getAttribute("data-usn");
    document.getElementById("usn").value = usn;
}
</script>

</head>

<body>

<h2>Pay Fee</h2>

<form action="scanner.jsp" method="post">

<select name="student_id" id="student" onchange="showUSN()">
<option value="">Select Student</option>
<option value="1" data-usn="USN001">Rahul</option>
<option value="2" data-usn="USN002">Anjali</option>
<option value="3" data-usn="USN003">Kiran</option>
<option value="4" data-usn="USN004">Sneha</option>
<option value="5" data-usn="USN005">Arjun</option>
</select>

<br><br>

USN:
<input type="text" id="usn" readonly>

<br><br>

Amount:
<input type="number" name="amount" required>

<br><br>

<button>Proceed to Pay</button>

</form>

</body>
</html>