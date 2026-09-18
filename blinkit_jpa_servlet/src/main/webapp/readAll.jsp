<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <title>ReadAll</title>
</head>

<body>

<h1>All Registers</h1>

<nav>
    <a href="home">Home</a>
    <br><br>
    <a href="redirectToRegister">Register</a>
    <br><br>
</nav>

<table border="2">

    <thead>
    <tr>
        <th>Name</th>
        <th>PhoneNumber</th>
        <th>Email</th>
        <th>Password</th>
    </tr>
    </thead>

    <tbody>

    <c:forEach items="${registerDtoList}" var="register">

        <tr>
            <td>${register.name}</td>
            <td>${register.phNumber}</td>
            <td>${register.email}</td>
            <td>${register.password}</td>
        </tr>

    </c:forEach>

    </tbody>

</table>

</body>
</html>