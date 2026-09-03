

<html>
<head>
    <title>Register</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<header class="bg-primary text-white p-3">
<div class="container d-flex justify-content-between align-items-center">

    <h3 class="mb-0">
        Registration
    </h3>

    <a href="index.jsp" class="btn btn-light">
        Home
    </a>

</div>
</header>



<div class="container mt-5">
<h2>Register</h2>

<form action="register" method="post">


    <div class="mb-3">
        <label class="form-label">
            Name
        </label>

        <input type="text"
               class="form-control"
               name="name">
    </div>



    <div class="mb-3">
        <label class="form-label">
            E-mail
        </label>

        <input type="email"class="form-control"name="email">
    </div>

    <div class="mb-3">
        <label class="form-label">
            Mobile
        </label>

        <input type="text"
               class="form-control"
               name="mobile">
    </div>

    <div class="mb-3">
        <label class="form-label">
            Password
        </label>

        <input type="password"
               class="form-control"
               name="password">
    </div>

    <button type="submit" class="btn btn-primary">
        Register
    </button>
</form>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js">
</script>
</body>
</html>
