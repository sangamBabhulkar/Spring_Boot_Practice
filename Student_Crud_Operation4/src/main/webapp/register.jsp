<!DOCTYPE html>
<html>
<head>
    <title>Register Student</title>
</head>

<body>

<h2>Student Registration</h2>

<form action="student" method="post" onsubmit="return validateForm()">

Name:
<input type="text" id="name" name="name"><br><br>

Email:
<input type="text" id="email" name="email" onblur="checkEmail()">
<span id="msg"></span><br><br>

Phone:
<input type="text" id="phone" name="phone"><br><br>

Course:
<input type="text" id="course" name="course"><br><br>

<button type="submit">Save</button>

</form>

<script src="js/validation.js"></script>

</body>
</html>