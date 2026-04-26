<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

<h2>Edit Fee</h2>

<form action="update" method="post">

<input type="hidden" name="id" value="<%=request.getAttribute("id")%>">

Name:
<input type="text" name="name" value="<%=request.getAttribute("name")%>"><br><br>

USN:
<input type="text" name="usn" value="<%=request.getAttribute("usn")%>"><br><br>

Total Fee:
<input type="text" name="fee" value="<%=request.getAttribute("fee")%>"><br><br>

<button>Update</button>

</form>

</body>
</html>