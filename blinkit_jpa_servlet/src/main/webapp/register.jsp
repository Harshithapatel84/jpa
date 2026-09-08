<html>
<head>
    <title>Register</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container mt-4">


<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <span class="navbar-brand mb-0 h1">Blinkit</span>
        <a href="index.jsp" class="btn btn-primary">Home</a>
    </div>
</nav>

<hr>

<h2>Register</h2>

<form action="register" method="post">

    <div class="mb-3">
        <label>Name</label>
        <input type="text" class="form-control" name="name">
    </div>

    <div class="mb-3">
        <label>Phone Number</label>
        <input type="text" class="form-control" name="PhNumber">
    </div>

    <div class="mb-3">
        <label>Email</label>
        <input type="email" class="form-control" name="Email">
    </div>

    <div class="mb-3">
        <label>Password</label>
        <input type="password" class="form-control" name="Password">
    </div>

    <button type="submit" class="btn btn-primary">Register</button>

</form>

<h4>${message}</h4>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>


<footer class="text-center mt-5">
    <hr>
    <p>&copy; 2026 Blinkit. All Rights Reserved.</p>
</footer>

</body>
</html>